package com.example.blog.application.user

import com.example.blog.domain.User
import com.example.blog.domain.repository.UserRepository
import com.example.blog.presentation.user.response.UserResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateUserService(
    private val userRepo: UserRepository
) {

    @Transactional
    fun create(firstname: String, lastname: String, description: String?): UserResponse {
        val createdUser = userRepo.save(
            User(
                firstname = firstname,
                lastname = lastname,
                description = description
            )
        )

        return UserResponse.from(createdUser)
    }
}