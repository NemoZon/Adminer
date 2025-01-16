package com.example.adminer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adminer.data.entities.User
import com.example.adminer.data.http.AuthService
import com.example.adminer.data.http.NetworkResult
import com.example.adminer.data.repositories.UsersRepository
import com.example.adminer.views.UsersUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UsersViewModel(
    private val usersRepository: UsersRepository
): ViewModel() {
    val usersUIState = MutableStateFlow(UsersUIState())
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
    private fun getMe() {
        val me = AuthService.getAuthUser()

        if (me != null) {
            usersUIState.update {
                it.copy(me = me)
            }
        } else {
            usersUIState.update {
                it.copy(me = null)
            }
        }
    }
    init {
        getUsers()
        getMe()
    }
}