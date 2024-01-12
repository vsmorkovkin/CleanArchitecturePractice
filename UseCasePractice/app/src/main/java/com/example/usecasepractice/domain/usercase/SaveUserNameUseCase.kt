package com.example.usecasepractice.domain.usercase

import com.example.usecasepractice.domain.models.SaveUserNameParam
import com.example.usecasepractice.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {
        val oldUserName = userRepository.getName()

        if (oldUserName.firstName == param.name) return true

        return userRepository.saveName(saveParam = param)
    }
}