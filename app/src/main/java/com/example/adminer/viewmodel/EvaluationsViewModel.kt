package com.example.adminer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adminer.data.entities.Lesson
import com.example.adminer.data.entities.Student
import com.example.adminer.data.http.NetworkResult
import com.example.adminer.data.repositories.EvaluationsRepository
import com.example.adminer.views.EvaluationsUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class EvaluationsViewModel(
    private val evaluationsRepository: EvaluationsRepository
): ViewModel() {
    val evaluationsUIState = MutableStateFlow(EvaluationsUIState())

    private fun getEvaluations() {
        evaluationsUIState.value = EvaluationsUIState(isLoading = true)
        viewModelScope.launch {
            when (val result = evaluationsRepository.getMockEvaluations()) {
                is NetworkResult.Success -> {
                    evaluationsUIState.update {
                        it.copy(isLoading = false, evaluations = result.data)
                    }
                }
                is NetworkResult.Error -> {
                    println("getEvaluations error: ${result.error}")
                    evaluationsUIState.update {
                        it.copy(isLoading = false, error = result.error)
                    }
                }
            }
        }
    }
    fun createEvaluation(student: Student, lesson: Lesson, value: Int) {
        evaluationsUIState.value = EvaluationsUIState(isLoading = true, evaluations = evaluationsUIState.value.evaluations)
        viewModelScope.launch {
            when (val result = evaluationsRepository.createMockEvaluation(
                student = student,
                lesson = lesson,
                value = value,
            )) {
                is NetworkResult.Success -> {
                    evaluationsUIState.update { state ->
                        state.copy(isLoading = false)
                    }
                }
                is NetworkResult.Error -> {
                    println("createEvaluation error: ${result.error}")
                    evaluationsUIState.update {
                        it.copy(isLoading = false, error = result.error)
                    }
                }
            }
        }
    }
    init {
        getEvaluations()
    }
}