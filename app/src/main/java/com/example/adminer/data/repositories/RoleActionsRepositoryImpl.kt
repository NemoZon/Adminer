package com.example.adminer.data.repositories

import com.example.adminer.data.entities.RoleActions
import com.example.adminer.data.http.NetworkResult
import com.example.adminer.data.mocks.roleActions
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class RoleActionsRepositoryImpl(
    private val dispatcher: CoroutineDispatcher
): RoleActionsRepository {
    override suspend fun getMockRoleActions(): NetworkResult<List<RoleActions>> {
        return withContext(dispatcher) {
            NetworkResult.Success(roleActions)
        }
    }
}