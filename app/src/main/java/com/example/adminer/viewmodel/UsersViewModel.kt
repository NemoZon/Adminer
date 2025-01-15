package com.example.adminer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adminer.data.http.NetworkResult
import com.example.adminer.data.UsersRepository
import com.example.adminer.views.UsersUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UsersViewModel(
    private val usersRepository: UsersRepository
): ViewModel() {
    private val usersUIState = MutableStateFlow(UsersUIState())
    private fun getUsers() {
        usersUIState.value = UsersUIState(isLoading = true)
        viewModelScope.launch {
            when (val result = usersRepository.getUsers()) {
                is NetworkResult.Success -> {
                    usersUIState.update {
                        it.copy(isLoading = false, users = result.data)
                    }
                }
                is NetworkResult.Error -> {
                    usersUIState.update {
                        it.copy(isLoading = false, error = result.error)
                    }
                }
            }
        }
    }
    init {
        getUsers()
    }
}