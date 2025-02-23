package com.example.adminer.views

import android.net.Uri
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.adminer.data.entities.Student
import com.example.adminer.navigation.Screens
import com.example.adminer.viewmodel.UsersViewModel
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.koin.androidx.compose.koinViewModel

@Composable
fun StudentList(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    val usersViewModel: UsersViewModel = koinViewModel()
    val usersUIState by usersViewModel.usersUIState.collectAsStateWithLifecycle()

    fun onStudentPressed(navHostController: NavHostController, student: Student) {
        try {
            val jsonStudent = Json.encodeToString(student)
            val encodedStudent = Uri.encode(jsonStudent)
            navHostController.navigate("${Screens.StudentDetailsScreen.route}/$encodedStudent")
        } catch (e: Exception) {
            Log.e("NavigationDebug", "Error: ${e.message}")
        }
    }

    Column(
        modifier = modifier
            .padding(20.dp, 20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibility(visible = usersUIState.isLoading
        ) {
            CircularProgressIndicator()
        }
        Text(
            text = "Students List",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        AnimatedVisibility(
            visible = usersUIState.students.isNotEmpty()
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(usersUIState.students) { student ->
                    StudentView(student = student, onClick = {
                        onStudentPressed(navHostController = navHostController, student = student)
                    })
                }
            }
        }

    }
}