package com.cc.fairy.converter

import kotlinx.serialization.SerializationStrategy
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.Converter

internal class SerializationStrategyConverter<T>(
    private val mediaType: MediaType,
    private val strategy: SerializationStrategy<T>,
    private val serializer: JsonSerializer
) : Converter<T, RequestBody> {
    override fun convert(value: T) = serializer.toRequestBody(mediaType, strategy, value)
}