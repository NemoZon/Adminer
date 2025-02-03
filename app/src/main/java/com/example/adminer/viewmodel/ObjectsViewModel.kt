package com.example.adminer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adminer.data.http.NetworkResult
import com.example.adminer.data.repositories.ObjectRepository
import com.example.adminer.views.ObjectsUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ObjectsViewModel(
    private val objectRepository: ObjectRepository
): ViewModel() {
    val objectsUIState = MutableStateFlow(ObjectsUIState())

    private fun getObjects() {
        objectsUIState.value = ObjectsUIState(isLoading = true)
        viewModelScope.launch {
            when (val result = objectRepository.getMockObjects()) {
                is NetworkResult.Success -> {
                    objectsUIState.update {
                        it.copy(isLoading = false, objects = result.data)
                    }
                }
                is NetworkResult.Error -> {
                    println("getLessons error: ${result.error}")
                    objectsUIState.update {
                        it.copy(isLoading = false, error = result.error)
                    }
                }
            }
        }
    }
    init {
        getObjects()
    }
}