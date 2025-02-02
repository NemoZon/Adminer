package com.example.adminer.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.adminer.data.entities.Student

@Composable
fun StudentDetailsScreenContent(
    modifier: Modifier = Modifier,
    student: Student,

) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text("Student Detail", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))

        AsyncImage(
            model = student.avatar,
            contentDescription = "Student Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text("Name: ${student.firstName} ${student.lastName}", fontSize = 16.sp, fontWeight = FontWeight.Medium)
        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(0.9f),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Evaluations", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Value: 10/20", fontSize = 16.sp, fontWeight = FontWeight.Medium)
                Text("Lesson: DevOps", fontSize = 16.sp, fontWeight = FontWeight.Medium)
                Text("Day: 01/01/2025", fontSize = 16.sp, fontWeight = FontWeight.Medium)
                Text("Time: 09:00 - 11:00", fontSize = 16.sp, fontWeight = FontWeight.Medium)
            }
        }

        FloatingActionButton(
            onClick = { /* Add new evaluation */ },
            containerColor = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(16.dp)
        ) {
            Text("+")
        }
    }
}
