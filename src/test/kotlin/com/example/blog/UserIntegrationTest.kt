package com.example.blog

import com.example.blog.application.user.CreateUserService
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CreateUserIntegrationTest(srv: CreateUserService) : BehaviorSpec() {

    override fun extensions() = listOf(SpringExtension)

    init {
        this.given("유저") {
            val firstname = "이름"
            val lastname = "성"
            val description = "설명"

            `when`("올바른 파라미터로 생성") {
                val actual = srv.create(firstname = firstname, lastname = lastname, description = description)

                then("성공") {
                    actual.firstname shouldBe firstname
                    actual.lastname shouldBe lastname
                    actual.description shouldBe description
                }
            }
        }
    }
}