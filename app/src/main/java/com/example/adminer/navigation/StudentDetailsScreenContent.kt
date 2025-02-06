package com.example.adminer.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.adminer.data.entities.Evaluation
import com.example.adminer.data.entities.Lesson
import com.example.adminer.data.entities.Student
import com.example.adminer.viewmodel.EvaluationsViewModel
import com.example.adminer.viewmodel.UsersViewModel
import com.example.adminer.views.AddEvaluationDialog
import com.example.adminer.views.EvaluationCard
import org.koin.androidx.compose.koinViewModel

@Composable
fun StudentDetailsScreenContent(
    modifier: Modifier = Modifier,
    student: Student,
) {
    val evaluationsViewModel: EvaluationsViewModel = koinViewModel()

    val evaluationsUIState by evaluationsViewModel.evaluationsUIState.collectAsStateWithLifecycle()
    val studentEvaluations: List<Evaluation> = evaluationsUIState.evaluations.filter {
        eval -> eval.student == student.id
    }
    var showDialog by remember { mutableStateOf(false) }

    fun createEvaluation(student: Student, lesson: Lesson, value: Int) {
        evaluationsViewModel.createEvaluation(student, lesson, value)
    }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            AsyncImage(
                model = student.avatar,
                contentDescription = "Student Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
        }

        item {
            Text("Evaluations", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

        items(studentEvaluations) { eval ->
            EvaluationCard(modifier = Modifier, evaluation = eval)
        }

        item {
            Button(
                onClick = { showDialog = true },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("+")
            }
        }
    }

    if (showDialog) {
        AddEvaluationDialog(
            onDismiss = { showDialog = false },
            onConfirm = { lesson, grade ->
                createEvaluation(
                    student,
                    lesson,
                    grade.toInt(),
                )
            }
        )
    }
}
