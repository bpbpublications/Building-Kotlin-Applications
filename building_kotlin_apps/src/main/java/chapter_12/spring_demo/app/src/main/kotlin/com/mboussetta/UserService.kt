package com.mboussetta

import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun getUsers():List<User>? = userRepository.getUsers()
}
