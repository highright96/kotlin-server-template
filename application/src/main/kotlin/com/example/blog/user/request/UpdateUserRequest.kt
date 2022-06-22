package com.example.blog.user.request

data class UpdateUserRequest(
    val firstname: String,
    val lastname: String,
    val description: String? = null
)