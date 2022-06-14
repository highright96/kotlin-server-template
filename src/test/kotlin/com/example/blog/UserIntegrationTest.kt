package com.example.blog

import com.example.blog.application.user.service.CreateUserService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserIntegrationTest {

    @Autowired
    private lateinit var createUserService: CreateUserService

    @Test
    fun `create user test`() {
        val firstname = "Sangwoo"
        val lastname = "Nam"
        val description = "description"

        val actual = createUserService.create(firstname, lastname, description);

        assertThat(actual.firstname).isEqualTo(firstname)
        assertThat(actual.lastname).isEqualTo(lastname)
        assertThat(actual.description).isEqualTo(description)
    }
}