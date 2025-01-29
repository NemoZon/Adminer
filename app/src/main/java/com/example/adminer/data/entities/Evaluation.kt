package com.example.adminer.data.entities
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Evaluation(
    @SerialName("_id") val id: String,
    @SerialName("value") val value: Int,
    @SerialName("lesson") val lesson: String,
    @SerialName("student") val student: String
)