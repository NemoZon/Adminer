package com.example.adminer.data.repositories

import com.example.adminer.data.entities.Lesson
import com.example.adminer.data.http.NetworkResult

interface LessonsRepository {
    suspend fun getMockLessons(): NetworkResult<List<Lesson>>
}