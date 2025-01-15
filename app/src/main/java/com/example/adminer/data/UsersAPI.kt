package com.example.adminer.data

import com.example.adminer.data.entities.User
import retrofit2.Response
import retrofit2.http.GET

interface UsersAPI {
    @GET("users")
    suspend fun fetchUsers(): Response<List<User>>
}