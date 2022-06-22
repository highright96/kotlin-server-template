package com.example.blog.user

import com.example.blog.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UpdateUserService(private val userRepo: UserRepository) {

    @Transactional
    fun update(userId: Long, firstname: String, lastname: String, description: String?) {
        val user = userRepo.findById(userId).orElseThrow {
            throw IllegalArgumentException("해당 유저는 존재하지 않습니다.")
        }

        user.update(
            firstname = firstname,
            lastname = lastname,
            description = description
        )
    }
}