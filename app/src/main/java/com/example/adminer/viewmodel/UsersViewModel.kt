package com.example.adminer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
                    println("getUsers error: ${result.error}")
                    usersUIState.update {
                        it.copy(isLoading = false, error = result.error)
                    }
                }
            }
        }
    }
    private fun getStudents() {
        usersUIState.value = UsersUIState(isLoading = true)
        viewModelScope.launch {
            when (val result = usersRepository.getStudents()) {
                is NetworkResult.Success -> {
                    usersUIState.update {
                        it.copy(isLoading = false, students = result.data)
                    }
                }
                is NetworkResult.Error -> {
                    println("Error fetching students: ${result.error}")
                    usersUIState.update {
                        it.copy(isLoading = false, error = result.error)
                    }
                }
            }
        }
    }
    private fun getAdmins() {
        usersUIState.value = UsersUIState(isLoading = true)
        viewModelScope.launch {
            when (val result = usersRepository.getAdmins()) {
                is NetworkResult.Success -> {
                    usersUIState.update {
                        it.copy(isLoading = false, admins = result.data)
                    }
                }
                is NetworkResult.Error -> {
                    println("getAdmins error: ${result.error}")
                    usersUIState.update {
                        it.copy(isLoading = false, error = result.error)
                    }
                }
            }
        }
    }
    private fun getSpeakers() {
        usersUIState.value = UsersUIState(isLoading = true)
        viewModelScope.launch {
            when (val result = usersRepository.getSpeakers()) {
                is NetworkResult.Success -> {
                    usersUIState.update {
                        it.copy(isLoading = false, speakers = result.data)
                    }
                }
                is NetworkResult.Error -> {
                    println("getSpeakers error: ${result.error}")
                    usersUIState.update {
                        it.copy(isLoading = false, error = result.error)
                    }
                }
            }
        }
    }
    fun getMe() {
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
        getStudents()
        getUsers()
        getMe()
        getSpeakers()
        getAdmins()
    }
}