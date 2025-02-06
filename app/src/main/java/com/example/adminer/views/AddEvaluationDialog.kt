package com.example.adminer.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.adminer.data.entities.Lesson
import com.example.adminer.data.entities.Object
import com.example.adminer.data.entities.Speaker
import com.example.adminer.viewmodel.LessonsViewModel
import com.example.adminer.viewmodel.ObjectsViewModel
import com.example.adminer.viewmodel.UsersViewModel
import org.koin.androidx.compose.koinViewModel

import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun AddEvaluationDialog(
    onDismiss: () -> Unit,
    onConfirm: (lesson: Lesson, grade: String) -> Unit,
) {
    val lessonsViewModel: LessonsViewModel = koinViewModel()
    val lessonsUIState by lessonsViewModel.lessonsUIState.collectAsStateWithLifecycle()

    val objectsViewModel: ObjectsViewModel = koinViewModel()
    val objectsUIState by objectsViewModel.objectsUIState.collectAsStateWithLifecycle()

    val usersViewModel: UsersViewModel = koinViewModel()
    val usersUIState by usersViewModel.usersUIState.collectAsStateWithLifecycle()


    val lessons = lessonsUIState.lessons
    val speakers = usersUIState.speakers
    val objects = objectsUIState.objects

    var selectedLesson by remember { mutableStateOf(lessons.firstOrNull()) }
    var grade by remember { mutableStateOf("") }

    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(text = "Add Evaluation", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        },
        text = {
            Column {
                Text("Lesson", fontWeight = FontWeight.Medium)

                var expanded by remember { mutableStateOf(false) }

                Box(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = selectedLesson?.let { lesson ->
                            val subjectTitle = objects.find { it.id == lesson.subject }?.title ?: "Unknown Subject"
                            val speaker = speakers.find { it.id == lesson.speaker }
                            val speakerName = speaker?.let { "${it.firstName} ${it.lastName}" } ?: "Unknown Speaker"
                            val day = dateFormat.format(lesson.startDate)
                            val time = "${timeFormat.format(lesson.startDate)} - ${timeFormat.format(lesson.endDate)}"

                            "$subjectTitle | $speakerName | $day | $time"
                        } ?: "Select Lesson",
                        onValueChange = {},
                        readOnly = true,
                        modifier = Modifier.fillMaxWidth(),
                        trailingIcon = {
                            IconButton(onClick = { expanded = !expanded }) {
                                Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Dropdown")
                            }
                        }
                    )

                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        lessons.forEach { lesson ->
                            val subjectTitle = objects.find { it.id == lesson.subject }?.title ?: "Unknown Subject"
                            val speaker = speakers.find { it.id == lesson.speaker }
                            val speakerName = speaker?.let { "${it.firstName} ${it.lastName}" } ?: "Unknown Speaker"
                            val day = dateFormat.format(lesson.startDate)
                            val time = "${timeFormat.format(lesson.startDate)} - ${timeFormat.format(lesson.endDate)}"

                            DropdownMenuItem(
                                text = { Text("$subjectTitle | $speakerName | $day | $time") },
                                onClick = {
                                    selectedLesson = lesson
                                    expanded = false
                                }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text("Grade", fontWeight = FontWeight.Medium)
                OutlinedTextField(
                    value = grade,
                    onValueChange = { grade = it },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    selectedLesson?.let { lesson ->
                        onConfirm(lesson, grade)
                        onDismiss()
                    }
                },
                enabled = selectedLesson != null && grade.isNotEmpty()
            ) {
                Text("Add")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss, colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)) {
                Text("Cancel")
            }
        }
    )
}
