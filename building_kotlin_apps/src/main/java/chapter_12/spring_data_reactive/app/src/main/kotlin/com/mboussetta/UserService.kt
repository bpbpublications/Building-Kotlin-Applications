package com.mboussetta

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UserService(private val userRepository: UserRepository) {

    fun getUsers(): Flux<User> = userRepository.findAll()
    fun getUserById(id: String): Mono<User> = userRepository.findById(id)

    fun createUser(user: User): Mono<User> = userRepository.save(user)
    fun deleteUserById(id: String) = userRepository.deleteById(id)
    fun updateUser(user: User) = userRepository.save(user)
}

