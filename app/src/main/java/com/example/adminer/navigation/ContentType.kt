package com.example.adminer.navigation

sealed interface ContentType {
    object List : ContentType
    object ListAndDetail : ContentType
}