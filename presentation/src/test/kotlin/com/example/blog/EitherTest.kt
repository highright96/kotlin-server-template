package com.example.blog

import arrow.core.Either
import io.kotest.core.spec.style.FreeSpec
import org.junit.jupiter.api.Test

class EitherTest : FreeSpec() {

    @Test
    fun either() {
        parse1("bc")
        //parse2("bc")
    }

    @Test
    fun run() {
        val right: Either<String, Int> = Either.Right(5)
        println(right)

        val left: Either<String, Int> = Either.Left("exception")
        println(left)
    }


    private fun parse1(s: String): Int =
        if (s.startsWith("a")) s.toInt()
        else throw NumberFormatException("$s is not a valid integer.")

    private fun parse2(s: String): Either<NumberFormatException, Int> =
        if (s.startsWith("a")) Either.Right(s.toInt())
        else Either.Left(NumberFormatException("$s is not a valid integer."))
}