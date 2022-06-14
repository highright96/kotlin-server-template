package com.example.blog.presentation.user.request

data class SignUpRequest(
    val firstname: String,
    val lastname: String,
    val description: String? = null
)