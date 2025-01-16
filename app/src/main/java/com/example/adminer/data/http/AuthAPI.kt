package com.example.adminer.data.http

import com.example.adminer.data.entities.User
import retrofit2.Response
import retrofit2.http.POST

interface AuthAPI {
    @POST("login")
    suspend fun login(email: String, password: String): Response<User>
}