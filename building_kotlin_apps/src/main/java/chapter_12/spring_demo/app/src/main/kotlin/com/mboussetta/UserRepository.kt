package com.mboussetta

import org.springframework.stereotype.Repository

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

    fun getUsers(): List<User>? = DATABASE["users"]

}
