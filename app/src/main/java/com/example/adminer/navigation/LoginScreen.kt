package com.example.adminer.navigation
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun LoginScreen(
    navHostController: NavHostController
) {
    LoginScreenContent(
        modifier = Modifier
            .fillMaxSize(),
        navHostController,
    )
}