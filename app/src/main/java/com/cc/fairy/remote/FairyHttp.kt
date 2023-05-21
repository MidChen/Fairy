package com.cc.fairy.remote

import com.cc.fairy.converter.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object FairyHttp {

    private const val baseurl = ""
    private val mediaType = "application/json".toMediaType()
    private val json = Json {
        ignoreUnknownKeys = true
    }

    private val instance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(json.asConverterFactory(mediaType))
            .build()
    }

    fun api(): FairyApi {
        return instance.create(FairyApi::class.java)
    }

}