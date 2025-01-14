package com.example.adminer.data

interface UsersRepository {
    suspend fun getUsers(): NetworkResult<List<User>>
}