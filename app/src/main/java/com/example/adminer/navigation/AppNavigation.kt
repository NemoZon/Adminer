package com.example.adminer.navigation

import android.net.Uri
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.adminer.data.entities.Student
import kotlinx.serialization.json.Json

@Composable
fun AppNavigation(
    navHostController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navHostController,
        startDestination = Screens.LoginScreen.route
    ) {
        composable(Screens.LoginScreen.route) {
            LoginScreen(navHostController)
        }
        composable(Screens.HomeScreen.route) {
            HomeScreen(navHostController)
        }
        composable(
            route = "${Screens.StudentDetailsScreen.route}/{student}",
            arguments = listOf(
                navArgument("student") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val encodedStudent = backStackEntry.arguments?.getString("student") ?: ""
            val student = try {
                Json.decodeFromString<Student>(Uri.decode(encodedStudent))
            } catch (e: Exception) {
                Log.e("NavigationDebug", "Error deserializing student: ${e.message}")
                null
            }
            if (student != null) {
                StudentDetailsScreen(
                    onBackPressed = {
                        navHostController.popBackStack()
                    },
                    student = student
                )
            } else {
                Log.e("NavigationDebug", "Failed to navigate to details screen due to invalid data.")
            }
        }
    }
}
