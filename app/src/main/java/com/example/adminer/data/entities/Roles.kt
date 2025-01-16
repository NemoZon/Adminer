package com.example.adminer.data.entities

enum class Role(private val roleName: String) {
    ADMIN("ADMIN"),
    STUDENT("STUDENT"),
    SPEAKER("SPEAKER");

    fun displayRole() {
        println("Role: $roleName")
    }
}