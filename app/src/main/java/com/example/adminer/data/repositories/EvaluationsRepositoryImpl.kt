package com.example.adminer.data.repositories

import com.example.adminer.data.entities.Evaluation
import com.example.adminer.data.http.NetworkResult
import com.example.adminer.data.mocks.evaluations

class EvaluationsRepositoryImpl(
): EvaluationsRepository {
    override suspend fun getMockEvaluations(): NetworkResult<List<Evaluation>> {
        return NetworkResult.Success(evaluations)
    }
}