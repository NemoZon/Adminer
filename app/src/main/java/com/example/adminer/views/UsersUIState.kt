package com.example.adminer.views

import com.example.adminer.data.entities.Admin
import com.example.adminer.data.entities.Speaker
import com.example.adminer.data.entities.Student
import com.example.adminer.data.entities.User
import com.example.adminer.data.entities.UserRole

data class UsersUIState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
    val students: List<Student> = emptyList(),
    val admins: List<Admin> = emptyList(),
    val speakers: List<Speaker> = emptyList(),
    val me: UserRole? = null,
    val error: String? = null
)