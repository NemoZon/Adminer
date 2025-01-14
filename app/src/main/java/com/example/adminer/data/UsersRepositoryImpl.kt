package com.example.adminer.data

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
}