package com.cc.fairy.converter

import kotlinx.serialization.*
import okhttp3.MediaType
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

@ExperimentalSerializationApi
internal class Factory(
    private val mediaType: MediaType,
    private val jsonSerializer: JsonSerializer
) : Converter.Factory() {

    override fun responseBodyConverter(
        type: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, *> {
        val serializer = jsonSerializer.serializer(type)
        return DeserializationStrategyConverter(serializer, jsonSerializer)
    }


    override fun requestBodyConverter(
        type: Type,
        parameterAnnotations: Array<out Annotation>,
        methodAnnotations: Array<out Annotation>,
        retrofit: Retrofit
    ): Converter<*, RequestBody> {
        val saver = jsonSerializer.serializer(type)
        return SerializationStrategyConverter(mediaType, saver, jsonSerializer)
    }
}


@OptIn(ExperimentalSerializationApi::class)
@JvmName("create")
fun StringFormat.asConverterFactory(mediaType: MediaType): Converter.Factory {
    return Factory(mediaType, JsonSerializer.FormatString(this))
}

//@ExperimentalSerializationApi
//@JvmName("create")
//fun BinaryFormat.asConverterFactory(contentType: MediaType): Converter.Factory {
//    return Factory(contentType, JsonSerializer.FormatBytes(this))
//}