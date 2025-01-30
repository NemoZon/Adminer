package com.example.adminer.data.http

import com.example.adminer.data.entities.Role
import com.example.adminer.data.entities.RoleEnum
import com.example.adminer.data.entities.User
import com.example.adminer.data.entities.UserRole
import com.example.adminer.data.mocks.admins
import com.example.adminer.data.mocks.speakers
import com.example.adminer.data.mocks.students
import com.example.adminer.data.mocks.userList

class AuthService {
    companion object {
        private var myUser: User? = null;
        private var myRole: Role? = null;

        fun login(email: String, password: String): NetworkResult<User> {
            val user = userList.find { it.password == password && it.email == email }
            return if (user != null) {
                myUser = user
                NetworkResult.Success(user)
            } else {
                NetworkResult.Error("Identifiants incorrects")
            }
        }
        fun getAuthUser(): UserRole? {
            if (myUser == null) return null

            if (myRole == null) {
                myRole = when (myUser!!.role) {
                    RoleEnum.STUDENT -> students.find { it.id == myUser!!.roleId }
                    RoleEnum.SPEAKER -> speakers.find { it.id == myUser!!.roleId }
                    RoleEnum.ADMIN -> admins.find { it.id == myUser!!.roleId }
                }
            }

            return myRole?.let { UserRole(myUser!!, it) }
        }
    }
}