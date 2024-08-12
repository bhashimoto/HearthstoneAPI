package com.example.hearthstoneapi.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Url
import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://omgvamp-hearthstone-v1.p.rapidapi.com/"
private var interceptor = HttpLoggingInterceptor()
private val client = OkHttpClient.Builder()
    .connectTimeout(10, TimeUnit.SECONDS)
    .writeTimeout(10, TimeUnit.SECONDS)
    .readTimeout(10, TimeUnit.SECONDS)
    .addInterceptor(interceptor.setLevel(HttpLoggingInterceptor.Level.BODY))
    .build()
private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl( BASE_URL)
    .client(client)
    .build()

interface HearthstoneApiService {
    @Headers(
        "x-rapidapi-key: 2d23f91ba3msh6fd7b7c548671bbp16a5a4jsn9fd3a22b9963",
        "x-rapidapi-host: omgvamp-hearthstone-v1.p.rapidapi.com"
        )
    @GET("cards/{cardId}")
    suspend fun getCard(@Path("cardId") id: String) :List<CardDetail>

}

object HearthstoneApi {
    val retrofitService : HearthstoneApiService by lazy {
        retrofit.create(HearthstoneApiService::class.java)
    }
}