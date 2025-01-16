package com.example.adminer.data.mocks

import com.example.adminer.data.entities.Role
import com.example.adminer.data.entities.User

val user1 = User(id = "1", email = "user1@example.com", password = "password1", role = Role.ADMIN)
val user2 = User(id = "2", email = "user2@example.com", password = "password2", role = Role.STUDENT)
val user3 = User(id = "3", email = "user3@example.com", password = "password3", role = Role.SPEAKER)

val userList = listOf(user1, user2, user3)