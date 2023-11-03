package com.mboussetta

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@RestController
class UserController(private val userService: UserService) {


    @GetMapping("/users/{id}")
    fun getUserById(@PathVariable id: String): Mono<User> = userService.getUserById(id)

    @GetMapping("/users")
    fun getUsers(): Flux<User> = userService.getUsers()

    @PostMapping("/users/create")
    fun createUser(@RequestBody user: User): Mono<User> = userService.createUser(user)


    @DeleteMapping("/users/delete/{id}")
    fun deleteUser(@PathVariable id: String) = userService.deleteUserById(id)

    @PutMapping("/users/update")
    fun updateUser(@RequestBody user: User): Mono<User> = userService.updateUser(user)
}
