package com.example.cleanarchitecturepractice.domain.usercase

import com.example.cleanarchitecturepractice.domain.models.UserName
import com.example.cleanarchitecturepractice.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}