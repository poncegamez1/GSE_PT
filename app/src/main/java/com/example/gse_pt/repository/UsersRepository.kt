package com.example.gse_pt.repository

import com.example.gse_pt.model.Users

interface UsersRepository {

    suspend fun getAllUsers(): List<Users>

}