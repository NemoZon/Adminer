package com.example.adminer.views

import com.example.adminer.data.entities.Evaluation

data class EvaluationsUIState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val evaluations: List<Evaluation> = emptyList(),
)
