package com.example.adminer.data.repositories

import com.example.adminer.data.entities.Evaluation
import com.example.adminer.data.http.NetworkResult

interface EvaluationsRepository {
    suspend fun getMockEvaluations(): NetworkResult<List<Evaluation>>
}