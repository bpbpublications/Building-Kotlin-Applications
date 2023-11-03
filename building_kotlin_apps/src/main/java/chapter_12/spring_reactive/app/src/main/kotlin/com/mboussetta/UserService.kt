package com.mboussetta

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UserService(private val userRepository: UserRepository) {

    fun getUsers(): Flux<User> = userRepository.getUsers()
    fun getUserById(id: Long): Mono<User> = userRepository.findUserById(id)
}
