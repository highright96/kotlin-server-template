package com.example.blog.presentation.user

import com.example.blog.application.user.CreateUserService
import com.example.blog.presentation.user.request.SignUpRequest
import com.example.blog.presentation.user.response.UserResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class CreateUserController(
    private val srv: CreateUserService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun create(@RequestBody req: SignUpRequest): UserResponse {
        return req.run {
            srv.create(
                firstname = req.firstname,
                lastname = req.lastname,
                description = req.description
            )
        }
    }
}