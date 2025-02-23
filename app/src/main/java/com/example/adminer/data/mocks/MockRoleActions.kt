package com.example.adminer.data.mocks

import com.example.adminer.data.entities.ActionEnum
import com.example.adminer.data.entities.RoleActions
import com.example.adminer.data.entities.RoleEnum

val roleActions: List<RoleActions> = listOf(
    RoleActions(
        id = "1",
        role = RoleEnum.ADMIN,
        actions = listOf(ActionEnum.EVALUATION_CREATE),
    ),
    RoleActions(
        id = "2",
        role = RoleEnum.SPEAKER,
        actions = listOf(ActionEnum.EVALUATION_CREATE),
    ),
)