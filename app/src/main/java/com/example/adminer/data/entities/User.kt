package com.example.adminer.data.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
open class User(
    @SerialName("_id") val id: String,
    @SerialName("email") val email: String,
    @SerialName("password") val password: String,
    @SerialName("role") val role: RoleEnum,
    @SerialName("roleId") val roleId: String
)

@Serializable
data class Speaker(
    @SerialName("_id") val id: String,
    @SerialName("firstName") val firstName: String,
    @SerialName("lastName") val lastName: String,
    @SerialName("avatar") val avatar: String,
    @SerialName("objects") val objects: List<String>
): Role()

@Serializable
data class Student(
    @SerialName("_id") val id: String,
    @SerialName("firstName") val firstName: String,
    @SerialName("lastName") val lastName: String,
    @SerialName("avatar") val avatar: String,
    @SerialName("evaluations") val evaluations: List<String>,
    @SerialName("absences") val absences: List<String>,
    @SerialName("class") val className: String
): Role()

@Serializable
data class Admin(
    @SerialName("_id") val id: String,
): Role()
