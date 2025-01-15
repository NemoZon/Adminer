package com.example.adminer.data.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("_id")
    val id: String,
    @SerialName("email")
    val createdAt: String? = null,
    @SerialName("password")
    val owner: String? = null,
)
