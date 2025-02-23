package com.example.adminer.navigation

import android.net.Uri
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.adminer.data.entities.RoleEnum
import com.example.adminer.viewmodel.UsersViewModel
import com.example.adminer.views.Loading
import com.example.adminer.views.StudentList
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
) {
    val usersViewModel: UsersViewModel = koinViewModel()
    val usersUIState by usersViewModel.usersUIState.collectAsStateWithLifecycle()

    LaunchedEffect(usersUIState.me?.user?.roleId) {
        if (usersUIState.me?.user?.role == RoleEnum.STUDENT) {
            try {
                val student = usersUIState.students.find { it.id == usersUIState.me?.user?.roleId }
                println("student: $student")
                val jsonStudent = Json.encodeToString(student)
                val encodedStudent = Uri.encode(jsonStudent)
                navHostController.navigate("${Screens.StudentDetailsScreen.route}/$encodedStudent")
            } catch (e: Exception) {
                Log.e("NavigationDebug", "Error: ${e.message}")
            }
        }
    }
    if (usersUIState.me?.user?.role == RoleEnum.ADMIN || usersUIState.me?.user?.role == RoleEnum.SPEAKER) {
        StudentList(modifier, navHostController)
    } else {
        Loading(modifier)
    }
}