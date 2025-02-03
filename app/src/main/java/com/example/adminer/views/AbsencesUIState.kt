package com.example.adminer.views

import com.example.adminer.data.entities.Absence

data class AbsencesUIState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val absences: List<Absence> = emptyList(),
)