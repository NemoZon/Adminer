package com.example.adminer.navigation

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.adminer.data.entities.User
import com.example.adminer.data.http.AuthService
import com.example.adminer.data.http.NetworkResult
import com.example.adminer.viewmodel.UsersViewModel
import org.koin.androidx.compose.koinViewModel

fun onLoginPressed(email: String, password: String, navHostController: NavHostController, onSuccess: () -> Unit, onError: (message: String) -> Unit) {
    try {
        when (val result = AuthService.login(email, password)) {
            is NetworkResult.Success -> {
                val user: User = result.data
                onSuccess()
                navHostController.navigate(Screens.HomeScreen.route)
                Log.d("Login", "Login successful: $user")
            }
            is NetworkResult.Error -> {
                Log.e("Login", "Error during login: ${result.error}")
                onError(result.error)
            }
        }
    } catch (e: Exception) {
        Log.e("NavigationDebug", "Error: ${e.message}")
    }
}

@Composable
fun LoginScreenContent(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    ) {

    val usersViewModel: UsersViewModel = koinViewModel()
    var errorMessage by remember { mutableStateOf("") }
    val email = remember { mutableStateOf("admin1@example.com") }
    val password = remember { mutableStateOf("password1") }

    Column(
        modifier = modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Email Input
        TextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        // Password Input
        TextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth()
        )
        if (errorMessage.isNotEmpty()) {
            Text(errorMessage, modifier = Modifier.padding(top = 10.dp), color = Color.Red)
        }
        // Login Button
        Button(
            onClick = {
                val trimmedEmail = email.value.trim()
                val trimmedPassword = password.value.trim()

                if (trimmedEmail.isNotEmpty() && trimmedPassword.isNotEmpty()) {
                    onLoginPressed(trimmedEmail, trimmedPassword, navHostController,
                        { usersViewModel.getMe() }) { message ->
                        errorMessage = message
                    }
                } else {
                    errorMessage = "Email and password required"
                }},
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Login")
        }
    }
}
