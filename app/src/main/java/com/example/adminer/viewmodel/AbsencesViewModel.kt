package com.example.adminer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adminer.data.http.NetworkResult
import com.example.adminer.data.repositories.AbsencesRepository
import com.example.adminer.data.repositories.EvaluationsRepository
import com.example.adminer.views.AbsencesUIState
import com.example.adminer.views.EvaluationsUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AbsencesViewModel(
    private val absencesRepository: AbsencesRepository
): ViewModel() {
    val absencesUIState = MutableStateFlow(AbsencesUIState())

    private fun getEvaluations() {
        absencesUIState.value = AbsencesUIState(isLoading = true)
        viewModelScope.launch {
            when (val result = absencesRepository.getMockAbsences()) {
                is NetworkResult.Success -> {
                    absencesUIState.update {
                        it.copy(isLoading = false, absences = result.data)
                    }
                }
                is NetworkResult.Error -> {
                    println("getEvaluations error: ${result.error}")
                    absencesUIState.update {
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