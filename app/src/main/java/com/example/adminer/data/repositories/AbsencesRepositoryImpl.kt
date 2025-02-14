package com.example.adminer.data.repositories

import com.example.adminer.data.entities.Absence
import com.example.adminer.data.http.NetworkResult
import com.example.adminer.data.mocks.absences
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class AbsencesRepositoryImpl(
    private val dispatcher: CoroutineDispatcher
): AbsencesRepository {
    override suspend fun getMockAbsences(): NetworkResult<List<Absence>> {
        return withContext(dispatcher) {
            NetworkResult.Success(absences)
        }
    }
}