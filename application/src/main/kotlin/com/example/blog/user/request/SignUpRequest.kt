package com.example.blog.user.request

data class SignUpRequest(
    val firstname: String,
    val lastname: String,
    val description: String? = null
)