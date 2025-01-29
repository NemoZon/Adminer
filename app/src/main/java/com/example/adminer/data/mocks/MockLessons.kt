package com.example.adminer.data.mocks

import com.example.adminer.data.entities.Lesson
import java.util.Date

val lessons = listOf(
    Lesson(
        id = "1",
        speaker = "2",
        subject = "1",
        className = "1",
        room = "A11",
        startDate = Date("2025/01/01 08:00:00"),
        endDate = Date("2025/01/01 10:00:00")
    ),
    Lesson(
        id = "2",
        speaker = "5",
        subject = "3",
        className = "1",
        room = "A11",
        startDate = Date("2025/01/01 10:15:00"),
        endDate = Date("2025/01/01 12:15:00")
    )
)