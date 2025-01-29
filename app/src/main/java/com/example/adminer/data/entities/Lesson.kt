package com.example.adminer.data.entities

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
data class Lesson(
    @SerialName("_id") val id: String,
    @SerialName("speaker") val speaker: String,
    @SerialName("object") val subject: String,
    @SerialName("class") val className: String,
    @SerialName("room") val room: String,
    @Contextual @SerialName("startDate") val startDate: Date,
    @Contextual @SerialName("endDate") val endDate: Date
)