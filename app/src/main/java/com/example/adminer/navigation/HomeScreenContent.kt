package com.example.adminer.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.adminer.views.UsersUIState

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    usersUIState: UsersUIState,
) {
    val me = usersUIState.me

    Column(
        modifier = modifier
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("You are logged in as ${me?.email} ${me?.role} ")
    }
}