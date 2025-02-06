package com.example.adminer.data.repositories

import com.example.adminer.data.entities.RoleActions
import com.example.adminer.data.http.NetworkResult

interface RoleActionsRepository {
    suspend fun getMockRoleActions(): NetworkResult<List<RoleActions>>
}