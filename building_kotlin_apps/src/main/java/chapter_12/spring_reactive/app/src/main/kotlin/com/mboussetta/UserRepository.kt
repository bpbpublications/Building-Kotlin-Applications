package com.mboussetta

import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
class UserRepository {

    private val DATABASE = mapOf(
        "users" to listOf(
            User(1, "Mounir BOUSSETTA"),
            User(2, "John Doe"),
            User(3, "Jane Smith")
        ),
        "profile" to listOf()
    )

    fun getUsers(): Flux<User> = Flux.fromIterable(DATABASE["users"]!!)
    fun findUserById(id: Long): Mono<User> {
        val user: User? = DATABASE["users"]?.find { it.id == id }
        return if (user != null) Mono.just(user) else Mono.empty()
    }

}
