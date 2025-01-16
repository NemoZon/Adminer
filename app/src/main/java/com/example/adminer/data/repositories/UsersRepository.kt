package com.example.adminer.data.repositories

import com.example.adminer.data.entities.User
import com.example.adminer.data.http.NetworkResult

interface UsersRepository {
    suspend fun getUsers(): NetworkResult<List<User>>
    suspend fun getMockUsers(): NetworkResult<List<User>>
}