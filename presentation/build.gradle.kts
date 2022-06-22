plugins {
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.serialization")
    kotlin("plugin.spring")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")

    //Test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.kotest:kotest-runner-junit5:5.3.1")
    testImplementation("io.kotest:kotest-assertions-core:5.3.1")
    testImplementation("io.kotest.extensions:kotest-extensions-spring:1.1.1")
    testImplementation("com.ninja-squad:springmockk:3.1.0")

    //Database
    runtimeOnly("com.h2database:h2")

    implementation(project(":application"))
    implementation(project(":infrastructure"))
}