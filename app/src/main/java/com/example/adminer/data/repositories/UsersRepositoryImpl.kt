package com.example.adminer.data.repositories

import com.example.adminer.data.entities.Admin
import com.example.adminer.data.entities.Speaker
import com.example.adminer.data.entities.Student
import com.example.adminer.data.http.UsersAPI
import com.example.adminer.data.entities.User
import com.example.adminer.data.http.NetworkResult
import com.example.adminer.data.mocks.admins
import com.example.adminer.data.mocks.speakers
import com.example.adminer.data.mocks.students
import com.example.adminer.data.mocks.userList
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class UsersRepositoryImpl(
    private val dispatcher: CoroutineDispatcher
): UsersRepository {
    override suspend fun getUsers(): NetworkResult<List<User>> {
        return withContext(dispatcher) {
            NetworkResult.Success(userList)
        }
    }

    override suspend fun getStudents(): NetworkResult<List<Student>> {
        return withContext(dispatcher) {
            NetworkResult.Success(students)
        }
    }

    override suspend fun getAdmins(): NetworkResult<List<Admin>> {
        return withContext(dispatcher) {
            NetworkResult.Success(admins)
        }
    }

    override suspend fun getSpeakers(): NetworkResult<List<Speaker>> {
        return withContext(dispatcher) {
            NetworkResult.Success(speakers)
        }
    }
}