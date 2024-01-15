package com.example.cleanarchitecturepractice.domain.usercase

import com.example.cleanarchitecturepractice.domain.models.SaveUserNameParam
import com.example.cleanarchitecturepractice.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {
        val oldUserName = userRepository.getName()

        if (oldUserName.firstName == param.name) return true

        return userRepository.saveName(saveParam = param)
    }
}