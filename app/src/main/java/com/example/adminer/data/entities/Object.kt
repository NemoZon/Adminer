package com.example.adminer.data.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Object(
    @SerialName("_id") val id: String,
    @SerialName("title") val title: String,
    @SerialName("logo") val logo: String
)