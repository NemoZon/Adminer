package com.example.adminer.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
import com.example.adminer.data.entities.Student
import com.example.adminer.viewmodel.EvaluationsViewModel
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
        eval -> student.evaluations.find { it == eval.id } != null
    }
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = student.avatar,
            contentDescription = "Student Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text("Evaluations", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        AnimatedVisibility(
            visible = evaluationsUIState.evaluations.isNotEmpty()
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(studentEvaluations) { eval ->
                    EvaluationCard(modifier = Modifier, evaluation = eval)
                }
            }
        }
        if (showDialog) {
            AddEvaluationDialog(
                onDismiss = { showDialog = false },
                onConfirm = { lesson, grade ->
                    println("Selected Lesson: ${lesson.id}, Grade: $grade")
                }
            )
        }
        Button(
            onClick = { showDialog = true },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("+")
        }
    }
}
