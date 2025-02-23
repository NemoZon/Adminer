package com.example.adminer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adminer.data.entities.ActionEnum
import com.example.adminer.data.http.NetworkResult
import com.example.adminer.data.repositories.RoleActionsRepository
import com.example.adminer.views.RoleActionsUIState
import com.example.adminer.views.UsersUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RoleActionsViewModel(
    private val roleActionsRepository: RoleActionsRepository
): ViewModel() {
    val roleActionsUIState = MutableStateFlow(RoleActionsUIState())

    private fun getRoleActions() {
        roleActionsUIState.value = RoleActionsUIState(isLoading = true)
        viewModelScope.launch {
            when (val result = roleActionsRepository.getMockRoleActions()) {
                is NetworkResult.Success -> {
                    roleActionsUIState.update {
                        it.copy(isLoading = false, roleActions = result.data)
                    }
                }
                is NetworkResult.Error -> {
                    println("getLessons error: ${result.error}")
                    roleActionsUIState.update {
                        it.copy(isLoading = false, error = result.error)
                    }
                }
            }
        }
    }
    init {
        getRoleActions()
    }
}