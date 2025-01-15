package com.example.adminer.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
@Composable
fun AppNavigation(
    navHostController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navHostController,
        startDestination = Screens.LoginScreen.route
    ) {
        composable(Screens.LoginScreen.route) {
            LoginScreen {
                try {
                    Log.d("NavigationDebug", "HomeScreen")
                    navHostController.navigate(Screens.HomeScreen.route)
                } catch (e: Exception) {
                    Log.e("NavigationDebug", "Error serializing cat: ${e.message}")
                }
            }
        }
        composable(Screens.HomeScreen.route) {
            HomeScreen()
        }
    }
}
