package com.example.arrivework

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://drive.google.com"

object MusicListApi {
    private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

    val searchMusic :SearchMusic = retrofit.create(SearchMusic::class.java)
}

interface SearchMusic {
    @GET("/file/d/1o1nX3uFISrG1gR-jr_03Qlu4_KEZWhav/view")
    suspend fun getMusic (): Music
}