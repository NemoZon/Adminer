package com.example.adminer.data.repositories

import com.example.adminer.data.entities.Object
import com.example.adminer.data.http.NetworkResult

interface ObjectRepository {
    suspend fun getMockObjects(): NetworkResult<List<Object>>
}