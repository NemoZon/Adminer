package com.example.adminer.data.repositories

import com.example.adminer.data.entities.Class
import com.example.adminer.data.http.NetworkResult

interface ClassesRepository {
    suspend fun getMockClasses(): NetworkResult<List<Class>>
}