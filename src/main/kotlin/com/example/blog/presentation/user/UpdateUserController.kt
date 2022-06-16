package com.example.blog.presentation.user

import com.example.blog.application.user.UpdateUserService
import com.example.blog.presentation.user.request.UpdateUserRequest
import com.example.blog.presentation.user.response.UpdateUserResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UpdateUserController(
    private val srv: UpdateUserService
) {

    @PutMapping("/{user_id})")
    fun update(
        @PathVariable("user_id") id: Long,
        @RequestBody request: UpdateUserRequest
    ): UpdateUserResponse {
        srv.update(
            userId = id,
            firstname = request.firstname,
            lastname = request.lastname,
            description = request.description
        )

        return UpdateUserResponse(true)
    }
}