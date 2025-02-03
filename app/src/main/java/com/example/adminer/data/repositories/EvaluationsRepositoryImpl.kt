package com.example.adminer.data.repositories

import com.example.adminer.data.entities.Evaluation
import com.example.adminer.data.http.NetworkResult
import com.example.adminer.data.mocks.evaluations
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class EvaluationsRepositoryImpl(
    private val dispatcher: CoroutineDispatcher
): EvaluationsRepository {
    override suspend fun getMockEvaluations(): NetworkResult<List<Evaluation>> {
        return withContext(dispatcher) {
            NetworkResult.Success(evaluations)
        }
    }
}