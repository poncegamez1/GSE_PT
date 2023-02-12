package com.example.gse_pt.mapper

import com.example.gse_pt.dto.UsersDtoItem
import com.example.gse_pt.model.Users

object UserMapper {

    fun map(userItem: UsersDtoItem): Users {
        return Users(
            id = userItem.id,
            name = userItem.name,
            username = userItem.username,
            email = userItem.email,
            phone = userItem.phone,
            website = userItem.website
        )
    }
}