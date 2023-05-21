package com.cc.fairy.remote

import com.cc.fairy.model.ResultModel
import com.cc.fairy.model.UserModel
import retrofit2.http.FieldMap
import retrofit2.http.POST

interface FairyApi {

    @POST("user/login")
    suspend fun login(@FieldMap map: Map<String, String>): ResultModel<UserModel>

}