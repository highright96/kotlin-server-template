package com.example.blog.application.user

import com.example.blog.domain.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UpdateUserService(private val userRepo: UserRepository) {

    @Transactional
    fun update(userId: Long, firstname: String, lastname: String, description: String?) {

        userRepo.findById(userId)

        userRepo.findById(userId)
            .ifPresent {
            it.update(
                firstname = firstname,
                lastname = lastname,
                description = description
            )
        }
    }
}