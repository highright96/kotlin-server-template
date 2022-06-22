package com.example.blog.user.response

import com.fasterxml.jackson.annotation.JsonProperty

data class UpdateUserResponse(

    @JsonProperty("is_success")
    val isSuccess: Boolean
)