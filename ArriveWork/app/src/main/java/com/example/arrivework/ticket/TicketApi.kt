package com.example.arrivework

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://drive.google.com"

object TicketApi {
    private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

    val searchTicket :SearchTicket = retrofit.create(SearchTicket::class.java)
}

interface SearchTicket {
    @GET("/file/d/1HogOsz4hWkRwco4kud3isZHFQLUAwNBA/view")
    suspend fun getTicket (): Ticket
}