package com.example.adminer.data.mocks

import com.example.adminer.data.entities.Admin
import com.example.adminer.data.entities.RoleEnum
import com.example.adminer.data.entities.Speaker
import com.example.adminer.data.entities.Student
import com.example.adminer.data.entities.User

val userList: List<User> = listOf(
    User("1", "admin1@example.com", "password1", role = RoleEnum.ADMIN, roleId = "1"),
    User("2", "admin2@example.com", "password4", role = RoleEnum.ADMIN, roleId = "4"),
    User("3", "admin3@example.com", "password7", role = RoleEnum.ADMIN, roleId = "7"),
    User("4", "admin4@example.com", "password10", role = RoleEnum.ADMIN, roleId = "10"),
    User("5", "speaker1@example.com", "password2", role = RoleEnum.SPEAKER, roleId = "2"),
    User("6", "speaker2@example.com", "password5", role = RoleEnum.SPEAKER, roleId = "5"),
    User("7", "speaker3@example.com", "password8", role = RoleEnum.SPEAKER, roleId = "8"),
    User("8", "student1@example.com", "password3", role = RoleEnum.STUDENT, roleId = "3"),
    User("9", "student2@example.com", "password6", role = RoleEnum.STUDENT, roleId = "6"),
    User("10", "student3@example.com", "password9", role = RoleEnum.STUDENT, roleId = "9"),

)

val admins: List<Admin> = listOf(
    Admin("1"),
    Admin("4"),
    Admin("7"),
    Admin("10")
)

val speakers: List<Speaker> = listOf(
    Speaker("2", "John", "Doe", "https://picsum.photos/200?random=4", listOf("1")),
    Speaker("5", "Alice", "Smith", "https://picsum.photos/200?random=5", listOf("1", "3")),
    Speaker("8", "Charlie", "Brown", "https://picsum.photos/200?random=6", listOf("2"))
)

var students: List<Student> = listOf(
    Student("3", "Jane", "Doe", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZKqIbnrGeTF8r6379KgkQS9qx9DJJMar6vQ&s", listOf("1"), listOf("1"), "1"),
    Student("6", "Bob", "Smith", "https://t3.ftcdn.net/jpg/10/26/74/06/360_F_1026740666_QT9g78hpEacnZpycTOmyg3krOsJjzgkQ.jpg", listOf("2"), emptyList(), "1"),
    Student("9", "David", "Brown", "https://artproperty.net/storage/116336/conversions/studencheskaya_viza_i_vnzh_dlya_studentov_v_turczii-1000x_.jpg", listOf("3"), emptyList(), "1")
)