package com.example.blog.domain.repository

import com.example.blog.domain.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
}