package com.example.adminer.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.adminer.data.entities.Evaluation
import com.example.adminer.data.entities.Lesson
import com.example.adminer.data.entities.Student
import com.example.adminer.viewmodel.EvaluationsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun EvaluationList(
    modifier: Modifier = Modifier,
    student: Student,
    hasRightsToCRUD: Boolean
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

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Evaluations", fontSize = 18.sp, fontWeight = FontWeight.Bold)

        studentEvaluations.forEach { eval ->
            EvaluationCard(modifier = Modifier, evaluation = eval)
        }
        if (hasRightsToCRUD) {
            Button(
                onClick = { showDialog = true },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("+")
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
}