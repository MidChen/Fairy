package com.cc.fairy.converter

import kotlinx.serialization.*
import okhttp3.MediaType
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.ResponseBody
import java.lang.reflect.Type

internal sealed class JsonSerializer {

    abstract fun <T> fromResponseBody(strategy: DeserializationStrategy<T>, body: ResponseBody): T

    abstract fun <T> toRequestBody(mediaType: MediaType, strategy: SerializationStrategy<T>, value: T): RequestBody

    protected abstract val format: SerialFormat

    fun serializer(type: Type): KSerializer<Any> = format.serializersModule.serializer(type)

    class FormatString(override val format: StringFormat) : JsonSerializer() {
        override fun <T> fromResponseBody(strategy: DeserializationStrategy<T>, body: ResponseBody): T {
            val string = body.string()
            return format.decodeFromString(strategy, string)
        }

        override fun <T> toRequestBody(mediaType: MediaType, strategy: SerializationStrategy<T>, value: T): RequestBody {
            val string = format.encodeToString(strategy, value)
            return string.toRequestBody(mediaType)
        }
    }

//    class FormatBytes(override val format: BinaryFormat) : JsonSerializer() {
//        override fun <T> fromResponseBody(strategy: DeserializationStrategy<T>, body: ResponseBody): T {
//            val bytes = body.bytes()
//            return format.decodeFromByteArray(strategy, bytes)
//        }
//
//        override fun <T> toRequestBody(mediaType: MediaType, strategy: SerializationStrategy<T>, value: T): RequestBody {
//            val bytes = format.encodeToByteArray(strategy, value)
//            return bytes.toRequestBody(mediaType, 0)
//        }
//    }
}