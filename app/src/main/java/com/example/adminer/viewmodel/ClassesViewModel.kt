package com.example.adminer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adminer.data.http.NetworkResult
import com.example.adminer.data.repositories.ClassesRepository
import com.example.adminer.views.ClassesUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ClassesViewModel(
    private val classesRepository: ClassesRepository
): ViewModel()  {
    val classesUIState = MutableStateFlow(ClassesUIState())

    private fun getClasses() {
        classesUIState.value = ClassesUIState(isLoading = true)
        viewModelScope.launch {
            when (val result = classesRepository.getMockClasses()) {
                is NetworkResult.Success -> {
                    classesUIState.update {
                        it.copy(isLoading = false, classes = result.data)
                    }
                }
                is NetworkResult.Error -> {
                    println("getEvaluations error: ${result.error}")
                    classesUIState.update {
                        it.copy(isLoading = false, error = result.error)
                    }
                }
            }
        }
    }
    init {
        getClasses()
    }
}