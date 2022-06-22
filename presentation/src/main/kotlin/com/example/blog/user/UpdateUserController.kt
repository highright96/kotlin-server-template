package com.example.blog.user

import com.example.blog.user.request.UpdateUserRequest
import com.example.blog.user.response.UpdateUserResponse
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