package com.mboussetta

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@RestController
class UserController(private val userService: UserService) {


    @GetMapping("/users/{id}")
    fun getUserById(@PathVariable id: Long): Mono<User> = userService.getUserById(id)

    @GetMapping("/users")
    fun getUsers(): Flux<User> = userService.getUsers()
}
