package com.example.adminer.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.adminer.data.entities.Evaluation
import com.example.adminer.viewmodel.LessonsViewModel
import com.example.adminer.viewmodel.ObjectsViewModel
import org.koin.androidx.compose.koinViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun convertDayToString(date: Date): String {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return date.let { dateFormat.format(it) }
}

fun convertTimeGapToString(startDate: Date, endDate: Date): String {
    val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
    return "${timeFormat.format(startDate)} - ${timeFormat.format(endDate)}"
}

@Composable
fun EvaluationCard(
    modifier: Modifier = Modifier,
    evaluation: Evaluation,
) {
    val lessonsViewModel: LessonsViewModel = koinViewModel()
    val lessonsUIState by lessonsViewModel.lessonsUIState.collectAsStateWithLifecycle()

    val objectsViewModel: ObjectsViewModel = koinViewModel()
    val objectsUIState by objectsViewModel.objectsUIState.collectAsStateWithLifecycle()

    val lesson = lessonsUIState.lessons.find { it.id == evaluation.lesson }
    val subject = objectsUIState.objects.find{ it.id == (lesson?.subject ?: false) }
    val subjectTitle = subject?.title
    val day = if (lesson != null ) convertDayToString(lesson.startDate) else { "undefined" }
    val time = if (lesson != null ) convertTimeGapToString(lesson.startDate, lesson.endDate)
        else { "undefined" }

    Card(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(0.9f),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
    ) {
        Row {
            Column(modifier = Modifier.padding(16.dp)) {
                AsyncImage(
                    model = subject?.logo,
                    contentDescription = "Subject logo",
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Column(modifier = Modifier.padding(16.dp)) {
                Spacer(modifier = Modifier.height(8.dp))
                Text("Value: ${evaluation.value}/20", fontSize = 16.sp, fontWeight = FontWeight.Medium)
                Text("Lesson: $subjectTitle", fontSize = 16.sp, fontWeight = FontWeight.Medium)
                Text("Day: $day", fontSize = 16.sp, fontWeight = FontWeight.Medium)
                Text("Time: $time", fontSize = 16.sp, fontWeight = FontWeight.Medium)
            }
        }
    }
}