package com.example.adminer.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(
    navHostController: NavHostController
) {
    HomeScreenContent(
        modifier = Modifier.fillMaxSize(),
        navHostController = navHostController,
    )
}