package com.example.blog.user.response

import com.example.blog.domain.User
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

@JsonSerialize
data class UserResponse(
    @JsonProperty("user_id")
    val id: Long,

    @JsonProperty("firstname")
    val firstname: String,

    @JsonProperty("lastname")
    val lastname: String,

    @JsonProperty("description")
    val description: String? = null
) {

    companion object {
        fun from(user: User): UserResponse {
            return UserResponse(
                id = user.id!!,
                firstname = user.firstname,
                lastname = user.lastname,
                description = user.description
            )
        }
    }
}