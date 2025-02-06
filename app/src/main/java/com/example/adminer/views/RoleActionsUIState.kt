package com.example.adminer.views

import com.example.adminer.data.entities.RoleActions

data class RoleActionsUIState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val roleActions: List<RoleActions> = emptyList(),
)
