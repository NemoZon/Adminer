package com.example.adminer.data.repositories

import com.example.adminer.data.entities.Lesson
import com.example.adminer.data.http.NetworkResult
import com.example.adminer.data.mocks.lessons
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class LessonsRepositoryImpl(
    private val dispatcher: CoroutineDispatcher
): LessonsRepository {
    override suspend fun getMockLessons(): NetworkResult<List<Lesson>> {
        return withContext(dispatcher) {
            NetworkResult.Success(lessons)
        }
    }
}