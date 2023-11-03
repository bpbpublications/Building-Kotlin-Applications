package com.mboussetta

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class UserController(private val userService: UserService) {

    @GetMapping("/users")
    fun getUsers(): List<User>? = userService.getUsers()
}
