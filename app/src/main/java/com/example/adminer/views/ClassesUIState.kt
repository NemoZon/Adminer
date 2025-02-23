package com.example.adminer.views

import com.example.adminer.data.entities.Class

data class ClassesUIState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val classes: List<Class> = emptyList(),
)