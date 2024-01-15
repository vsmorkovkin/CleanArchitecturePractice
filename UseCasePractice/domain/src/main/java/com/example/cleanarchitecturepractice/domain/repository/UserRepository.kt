package com.example.cleanarchitecturepractice.domain.repository

import com.example.cleanarchitecturepractice.domain.models.SaveUserNameParam
import com.example.cleanarchitecturepractice.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName
}