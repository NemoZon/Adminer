package com.example.adminer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adminer.data.http.NetworkResult
import com.example.adminer.data.repositories.LessonsRepository
import com.example.adminer.views.LessonsUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LessonsViewModel(
    private val lessonsRepository: LessonsRepository
): ViewModel() {
    val lessonsUIState = MutableStateFlow(LessonsUIState())

    private fun getLessons() {
        lessonsUIState.value = LessonsUIState(isLoading = true)
        viewModelScope.launch {
            when (val result = lessonsRepository.getMockLessons()) {
                is NetworkResult.Success -> {
                    lessonsUIState.update {
                        it.copy(isLoading = false, lessons = result.data)
                    }
                }
                is NetworkResult.Error -> {
                    println("getLessons error: ${result.error}")
                    lessonsUIState.update {
                        it.copy(isLoading = false, error = result.error)
                    }
                }
            }
        }
    }
    init {
        getLessons()
    }
}