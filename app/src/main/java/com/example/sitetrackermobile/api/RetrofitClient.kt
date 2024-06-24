package com.example.sitetrackermobile.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
// RetrofitClient.kt
object RetrofitClient {
    private const val BASE_URL = "http://10.0.2.2:8081/" // Use the special alias for host loopback

    private val logging = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val topLevelProjectApi: TopLevelProjectApi = retrofit.create(TopLevelProjectApi::class.java)
}
