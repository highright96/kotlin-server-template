package com.example.blog

import com.example.blog.application.user.CreateUserService
import com.example.blog.application.user.UpdateUserService
import com.example.blog.domain.User
import com.example.blog.domain.repository.UserRepository
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CreateUserIntegrationTest(
    createUserService: CreateUserService,
    updateUserService: UpdateUserService,
    userRepository: UserRepository
) : BehaviorSpec() {

    override fun extensions() = listOf(SpringExtension)

    init {

        lateinit var testUser: User

        this.beforeTest {
            testUser = userRepository.save(
                User(
                    firstname = "유저",
                    lastname = "테스트",
                )
            )
        }

        this.given("회원가입") {
            val firstname = "이름"
            val lastname = "성"
            val description = "설명"

            `when`("올바른 파라미터로 생성") {
                val actual = createUserService.create(
                    firstname = firstname,
                    lastname = lastname,
                    description = description
                )

                then("성공") {
                    actual.firstname shouldBe firstname
                    actual.lastname shouldBe lastname
                    actual.description shouldBe description
                }
            }
        }

        this.given("회원정보 수정") {
            val updateFirstname = "수정한 이름"
            val updateLastname = "수정한 성"
            val updateDesc = "수정한 설명"

            `when`("올바른 파라미터로 수정") {
                updateUserService.update(
                    userId = testUser.id!!,
                    firstname = updateFirstname,
                    lastname = updateLastname,
                    description = updateDesc
                )

                then("성공") {
                    val expected = userRepository.findById(testUser.id!!).get()

                    expected.firstname shouldBe testUser.firstname
                    expected.lastname shouldBe testUser.lastname
                    expected.description shouldBe testUser.description
                }
            }

            `when`("잘못된 ID 사용") {
                then("실패 - IllegalArgumentException") {
                    shouldThrow<IllegalArgumentException> {
                        updateUserService.update(
                            userId = 1000L,
                            firstname = updateFirstname,
                            lastname = updateLastname,
                            description = updateDesc
                        )
                    }
                }
            }
        }
    }
}