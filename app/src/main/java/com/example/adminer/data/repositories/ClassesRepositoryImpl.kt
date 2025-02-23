package com.example.adminer.data.repositories

import com.example.adminer.data.entities.Class
import com.example.adminer.data.http.NetworkResult
import com.example.adminer.data.mocks.classes
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class ClassesRepositoryImpl(
    private val dispatcher: CoroutineDispatcher
): ClassesRepository {
    override suspend fun getMockClasses(): NetworkResult<List<Class>> {
        return withContext(dispatcher) {
            NetworkResult.Success(classes)
        }
    }
}