package com.example.blog.user

import com.example.blog.user.request.SignUpRequest
import com.example.blog.user.response.UserResponse
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