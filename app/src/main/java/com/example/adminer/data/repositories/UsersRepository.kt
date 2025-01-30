package com.example.adminer.data.repositories

import com.example.adminer.data.entities.Admin
import com.example.adminer.data.entities.Speaker
import com.example.adminer.data.entities.Student
import com.example.adminer.data.entities.User
import com.example.adminer.data.http.NetworkResult

interface UsersRepository {
    suspend fun getUsers(): NetworkResult<List<User>>
    suspend fun getStudents(): NetworkResult<List<Student>>
    suspend fun getAdmins(): NetworkResult<List<Admin>>
    suspend fun getSpeakers(): NetworkResult<List<Speaker>>
}