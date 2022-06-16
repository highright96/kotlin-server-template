package com.example.blog.presentation.user

import com.example.blog.application.user.UpdateUserService
import com.example.blog.presentation.user.request.UpdateUserRequest
import com.example.blog.presentation.user.response.UpdateUserResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UpdateUserController(
    private val srv: UpdateUserService
) {

    /*
    @PutMapping("/{id)")
    fun update(
        @PathVariable id: Long,
        @RequestBody request: UpdateUserRequest
    ): UpdateUserResponse {

    }*/
}