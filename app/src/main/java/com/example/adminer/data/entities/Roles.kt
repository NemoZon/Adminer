package com.example.adminer.data.entities

enum class RoleEnum(private val roleName: String) {
    ADMIN("ADMIN"),
    STUDENT("STUDENT"),
    SPEAKER("SPEAKER");

    fun displayRole() {
        println("Role: $roleName")
    }
}

sealed class Role

data class UserRole(val user: User, val role: Role)
