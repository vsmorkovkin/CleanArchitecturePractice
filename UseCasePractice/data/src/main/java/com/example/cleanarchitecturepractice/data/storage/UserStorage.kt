package com.example.cleanarchitecturepractice.data.storage

import com.example.cleanarchitecturepractice.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}