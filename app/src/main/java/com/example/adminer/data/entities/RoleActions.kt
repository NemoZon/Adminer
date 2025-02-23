package com.example.adminer.data.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

enum class ActionEnum(private val actionName: String) {
    EVALUATION_CREATE("EVALUATION_CREATE"),
}

@Serializable
data class RoleActions(
    @SerialName("_id") val id: String,
    @SerialName("role") val role: RoleEnum,
    @SerialName("actions") val actions: List<ActionEnum>,
)