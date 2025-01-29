package com.example.adminer.data.repositories

import com.example.adminer.data.entities.Lesson
import com.example.adminer.data.http.NetworkResult
import com.example.adminer.data.mocks.lessons

class LessonsRepositoryImpl(): LessonsRepository {
    override suspend fun getMockLessons(): NetworkResult<List<Lesson>> {
        return NetworkResult.Success(lessons)
    }
}