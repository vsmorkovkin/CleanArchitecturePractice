package com.example.usecasepractice.domain.usercase

import com.example.usecasepractice.domain.models.UserName
import com.example.usecasepractice.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}