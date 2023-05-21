package com.cc.fairy.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(val username: String,
                val password: String,
                val birthday: String,
                val email: String,
                val datetime: String)
{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}