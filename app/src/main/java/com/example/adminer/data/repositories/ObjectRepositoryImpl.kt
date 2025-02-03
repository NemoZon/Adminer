package com.example.adminer.data.repositories

import com.example.adminer.data.entities.Object
import com.example.adminer.data.http.NetworkResult
import com.example.adminer.data.mocks.objects
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class ObjectRepositoryImpl(
    private val dispatcher: CoroutineDispatcher
): ObjectRepository {
    override suspend fun getMockObjects(): NetworkResult<List<Object>> {
        return withContext(dispatcher) {
            NetworkResult.Success(objects)
        }
    }
}