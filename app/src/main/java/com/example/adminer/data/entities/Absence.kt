package com.example.adminer.data.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Absence(
    @SerialName("_id") val id: String,
    @SerialName("isJustified") val isJustified: Boolean,
    @SerialName("justification") val justification: String? = null,
    @SerialName("lesson") val lesson: String,
    @SerialName("student") val student: String
)