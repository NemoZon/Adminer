package com.example.adminer.data

import retrofit2.Response
import retrofit2.http.GET

interface UsersAPI {
    @GET("users")
    suspend fun fetchUsers(): Response<List<User>>
}