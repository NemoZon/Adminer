package com.example.adminer.data

import com.example.adminer.data.entities.User
import com.example.adminer.data.http.NetworkResult

interface UsersRepository {
    suspend fun getUsers(): NetworkResult<List<User>>
}