package com.example.gse_pt.repository.imp

import com.example.gse_pt.api.Api
import com.example.gse_pt.mapper.UserMapper
import com.example.gse_pt.model.Users
import com.example.gse_pt.repository.UsersRepository

class UserRepositoryImp(private val api: Api): UsersRepository {

    override suspend fun getAllUsers(): List<Users> {
        val response = api.getAllUsers()
        return response.map {UserMapper.map(it)}
    }

}