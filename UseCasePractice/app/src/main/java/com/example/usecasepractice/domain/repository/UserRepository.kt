package com.example.usecasepractice.domain.repository

import com.example.usecasepractice.domain.models.SaveUserNameParam
import com.example.usecasepractice.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName
}