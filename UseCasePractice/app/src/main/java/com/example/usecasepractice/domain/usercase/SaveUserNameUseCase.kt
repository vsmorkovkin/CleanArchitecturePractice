package com.example.usecasepractice.domain.usercase

import com.example.usecasepractice.domain.models.SaveUserNameParam

class SaveUserNameUseCase {

    fun execute(param: SaveUserNameParam): Boolean {
        return param.name.isNotEmpty()
    }
}