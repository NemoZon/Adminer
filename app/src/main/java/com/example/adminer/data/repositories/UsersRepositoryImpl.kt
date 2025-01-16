package com.example.adminer.data.repositories

import com.example.adminer.data.http.UsersAPI
import com.example.adminer.data.entities.User
import com.example.adminer.data.http.NetworkResult
import com.example.adminer.data.mocks.userList
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class UsersRepositoryImpl(
    private val usersAPI: UsersAPI,
    private val dispatcher: CoroutineDispatcher
): UsersRepository {
    override suspend fun getUsers(): NetworkResult<List<User>> {
        return withContext(dispatcher) {
            try {
                val response = usersAPI.fetchUsers()
                if (response.isSuccessful) {
                    NetworkResult.Success(response.body()!!)
                } else {
                    NetworkResult.Error(response.errorBody().toString())
                }
            } catch (e: Exception) {
                NetworkResult.Error(e.message ?: "Unknown error")
            }
        }
    }
    override suspend fun getMockUsers(): NetworkResult<List<User>> {
        return NetworkResult.Success(userList)
    }
}