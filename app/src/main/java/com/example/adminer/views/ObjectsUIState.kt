package com.example.adminer.views

import com.example.adminer.data.entities.Object

data class ObjectsUIState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val objects: List<Object> = emptyList(),
)
