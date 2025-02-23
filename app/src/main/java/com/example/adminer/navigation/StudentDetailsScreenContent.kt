package com.example.adminer.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.adminer.data.entities.Student
import com.example.adminer.viewmodel.UsersViewModel
import com.example.adminer.views.EvaluationList
import org.koin.androidx.compose.koinViewModel

@Composable
fun StudentDetailsScreenContent(
    modifier: Modifier = Modifier,
    student: Student,
) {
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
            EvaluationList(Modifier, student)
        }
    }

}
