package com.example.blog.presentation.user.request

data class UpdateUserRequest(
    val firstname: String,
    val lastname: String,
    val description: String? = null
)