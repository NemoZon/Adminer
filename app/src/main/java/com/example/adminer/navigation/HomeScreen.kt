package com.example.adminer.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.adminer.viewmodel.UsersViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen() {
    val usersViewModel: UsersViewModel = koinViewModel()
    val usersUIState by usersViewModel.usersUIState.collectAsStateWithLifecycle()
    HomeScreenContent(
        modifier = Modifier.fillMaxSize(),
        usersUIState = usersUIState
    )
}