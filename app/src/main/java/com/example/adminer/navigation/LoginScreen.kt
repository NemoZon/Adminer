package com.example.adminer.navigation
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LoginScreen(
    onLoginPressed: () -> Unit
) {
    LoginScreenContent(
        modifier = Modifier
            .fillMaxSize(),
        onLoginPressed,
    )
}