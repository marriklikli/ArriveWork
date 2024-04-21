package com.example.arrivework.first

import com.example.arrivework.MusicListApi
import com.example.arrivework.offers


class Repository {
    suspend fun getActivityInfo(): List<offers>{
        return try{
            MusicListApi.searchMusic.getMusic().offers
        } catch ( t:Throwable) {
            println("Ошибка $t")
            emptyList()
        }
    }
}