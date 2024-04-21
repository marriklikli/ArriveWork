package com.example.arrivework.country

import com.example.arrivework.CountryListApi
import com.example.arrivework.ticketsoffers

class CountryRepository {
    suspend fun getActivityInfo(): List<ticketsoffers> {
        return try {
            CountryListApi.searchCountry.getMusic().tickets_offers
        } catch (t: Throwable) {
            println("Ошибка $t")
            emptyList()
        }
    }
}