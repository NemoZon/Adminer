package com.example.adminer.data.mocks

import com.example.adminer.data.entities.Admin
import com.example.adminer.data.entities.Role
import com.example.adminer.data.entities.Speaker
import com.example.adminer.data.entities.Student
import com.example.adminer.data.entities.User

val userList: List<User> = listOf(
    User("1", "admin1@example.com", "password1", role = "1"),
    User("2", "admin2@example.com", "password4", role = "4"),
    User("3", "admin3@example.com", "password7", role = "7"),
    User("4", "admin4@example.com", "password10", role = "10"),
    User("5", "speaker1@example.com", "password2", role = "2"),
    User("6", "speaker2@example.com", "password5", role = "5"),
    User("7", "speaker3@example.com", "password8", role = "8"),
    User("8", "student1@example.com", "password3", role = "3"),
    User("9", "student2@example.com", "password6", role = "6"),
    User("10", "student3@example.com", "password9", role = "9"),

)

val admins: List<Admin> = listOf(
    Admin("1", Role.ADMIN),
    Admin("4", Role.ADMIN),
    Admin("7", Role.ADMIN),
    Admin("10", Role.ADMIN)
)

val speakers: List<Speaker> = listOf(
    Speaker("2", Role.SPEAKER, "John", "Doe", "https://picsum.photos/200?random=4", listOf("1")),
    Speaker("5", Role.SPEAKER, "Alice", "Smith", "https://picsum.photos/200?random=5", listOf("1", "3")),
    Speaker("8", Role.SPEAKER, "Charlie", "Brown", "https://picsum.photos/200?random=6", listOf("2"))
)

val students: List<Student> = listOf(
    Student("3", Role.STUDENT, "Jane", "Doe", "https://picsum.photos/200?random=3", listOf("1"), listOf("1"), "1"),
    Student("6", Role.STUDENT, "Bob", "Smith", "https://picsum.photos/200?random=1", listOf("2"), emptyList(), "1"),
    Student("9",  Role.STUDENT, "David", "Brown", "https://picsum.photos/200?random=2", listOf("3"), emptyList(), "1")
)