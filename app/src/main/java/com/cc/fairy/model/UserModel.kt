package com.cc.fairy.model

import kotlinx.serialization.Serializable

@Serializable
data class UserModel(val id: Int,
                     val username: String,
                     val email: String,
                     val icon: String,
)