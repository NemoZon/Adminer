package com.example.adminer.data.http

import com.example.adminer.data.entities.User
import com.example.adminer.data.mocks.userList

class AuthService {
    companion object {
        private var me: User? = null;
        fun login(email: String, password: String): NetworkResult<User> {
            val user = userList.find { it.password == password && it.email == email }
            return if (user != null) {
                me = user
                NetworkResult.Success(user)
            } else {
                NetworkResult.Error("Identifiants incorrects")
            }
        }
        fun getAuthUser(): User? {
            return me;
        }
    }
}