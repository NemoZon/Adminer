package com.example.adminer.views

import com.example.adminer.data.entities.Lesson

data class LessonsUIState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val lessons: List<Lesson> = emptyList(),
)
