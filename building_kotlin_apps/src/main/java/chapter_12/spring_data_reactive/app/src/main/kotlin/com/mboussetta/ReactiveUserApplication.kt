/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.mboussetta

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class ReactiveUserApplication(private val userRepository: UserRepository): CommandLineRunner {
    override fun run(vararg args: String?) {
        userRepository.save(User(null, "Patient One")).subscribe()

    }
}

fun main(args: Array<String>) {
    runApplication<ReactiveUserApplication>(*args)
}