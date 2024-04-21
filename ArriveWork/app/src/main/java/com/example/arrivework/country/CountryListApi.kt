package com.example.arrivework

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://drive.google.com"

object CountryListApi {  private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

    val searchCountry :SearchCountry = retrofit.create(SearchCountry::class.java)
}

interface SearchCountry {
    @GET("/file/d/13WhZ5ahHBwMiHRXxWPq-bYlRVRwAujta/view")
    suspend fun getMusic (): Country
}