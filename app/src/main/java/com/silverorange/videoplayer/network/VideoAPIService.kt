package com.silverorange.videoplayer.network

import com.silverorange.videoplayer.network.responses.VideoResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface VideoAPIService {

    @GET("videos")
    suspend fun fetchVideoList(): List<VideoResponse>?

    companion object {
        private const val BASE_URL = "http://localhost:4000/"

        fun create(): VideoAPIService {
            val client = OkHttpClient.Builder().apply {
                addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
            }.build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(VideoAPIService::class.java)
        }
    }
}