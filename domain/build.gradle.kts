plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
}

tasks.jar { enabled = true }

tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootJar> { enabled = false }

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    //Test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.kotest:kotest-runner-junit5:5.3.1")
    testImplementation("io.kotest:kotest-assertions-core:5.3.1")
    testImplementation("io.kotest.extensions:kotest-extensions-spring:1.1.1")
    testImplementation("com.ninja-squad:springmockk:3.1.0")

    testImplementation(project(":infrastructure"))
}
