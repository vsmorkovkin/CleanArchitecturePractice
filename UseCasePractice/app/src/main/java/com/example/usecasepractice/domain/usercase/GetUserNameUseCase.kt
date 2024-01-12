package com.example.usecasepractice.domain.usercase

import com.example.usecasepractice.domain.models.UserName

class GetUserNameUseCase {

    fun execute(): UserName {
        return UserName("Oleg", "Bocharov")
    }
}