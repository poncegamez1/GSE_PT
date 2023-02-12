package com.example.gse_pt.api

import com.example.gse_pt.dto.UsersDto
import com.example.gse_pt.dto.UsersDtoItem
import retrofit2.http.GET

interface Api {

    @GET("/users")
    suspend fun getAllUsers(): UsersDto

}