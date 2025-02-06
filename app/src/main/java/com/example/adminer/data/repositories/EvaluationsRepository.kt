package com.example.adminer.data.repositories

import com.example.adminer.data.entities.Evaluation
import com.example.adminer.data.entities.Lesson
import com.example.adminer.data.entities.Student
import com.example.adminer.data.http.NetworkResult

interface EvaluationsRepository {
    suspend fun getMockEvaluations(): NetworkResult<List<Evaluation>>
    suspend fun createMockEvaluation(student: Student, lesson: Lesson, value: Int): NetworkResult<Evaluation>
}