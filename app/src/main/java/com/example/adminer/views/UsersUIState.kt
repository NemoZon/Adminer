package com.example.adminer.views

import com.example.adminer.data.entities.User

data class UsersUIState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
    val error: String? = null
)