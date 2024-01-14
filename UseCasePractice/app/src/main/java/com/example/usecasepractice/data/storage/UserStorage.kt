package com.example.usecasepractice.data.storage

import com.example.usecasepractice.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}