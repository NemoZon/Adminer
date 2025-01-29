package com.example.adminer.data.mocks

import com.example.adminer.data.entities.Absence

val absences = listOf(
    Absence(
        id = "1",
        isJustified = true,
        justification = "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf",
        lesson = "2",
        student = "3"
    )
)