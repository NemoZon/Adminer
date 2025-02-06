package com.example.adminer.data.repositories

import com.example.adminer.data.entities.Evaluation
import com.example.adminer.data.entities.Lesson
import com.example.adminer.data.entities.Student
import com.example.adminer.data.http.NetworkResult
import com.example.adminer.data.mocks.evaluations
import com.example.adminer.data.mocks.students
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class EvaluationsRepositoryImpl(
    private val dispatcher: CoroutineDispatcher
): EvaluationsRepository {
    override suspend fun getMockEvaluations(): NetworkResult<List<Evaluation>> {
        return withContext(dispatcher) {
            NetworkResult.Success(evaluations)
        }
    }
    override suspend fun createMockEvaluation(student: Student, lesson: Lesson, value: Int): NetworkResult<Evaluation> {
        return withContext(dispatcher) {
            val newId = if (evaluations.isNotEmpty()) evaluations.last().id.toInt() + 1 else 1
            val newEvaluation = Evaluation(id = newId.toString(), value = value, lesson = lesson.id, student = student.id)
            students = students.map { studentEntity ->
                if (studentEntity.id == student.id) {
                    studentEntity.copy(evaluations = studentEntity.evaluations + newId.toString())
                } else {
                    studentEntity
                }
            }
            evaluations.add(newEvaluation)
            println("create mock eval: $evaluations")
            NetworkResult.Success(newEvaluation)
        }
    }
}