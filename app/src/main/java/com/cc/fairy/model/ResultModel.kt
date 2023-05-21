package com.cc.fairy.model

import kotlinx.serialization.Serializable

@Serializable
data class ResultModel<T>(val data: T ?, val code: Int, val msg: String)