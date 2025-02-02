package com.example.adminer.navigation

sealed class Screens(val route: String) {
    object LoginScreen : Screens("login")
    object HomeScreen : Screens("home")
    object StudentDetailsScreen : Screens("studentDetails")
}