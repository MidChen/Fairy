package com.cc.fairy.converter

import kotlinx.serialization.DeserializationStrategy
import okhttp3.ResponseBody
import retrofit2.Converter

internal class DeserializationStrategyConverter<T>(
    private val strategy: DeserializationStrategy<T>,
    private val serializer: JsonSerializer
) : Converter<ResponseBody, T> {
    override fun convert(value: ResponseBody) = serializer.fromResponseBody(strategy, value)
}