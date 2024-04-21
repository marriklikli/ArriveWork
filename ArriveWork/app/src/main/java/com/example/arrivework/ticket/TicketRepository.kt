package com.example.arrivework.ticket

import com.example.arrivework.TicketApi
import com.example.arrivework.Tickets

class TicketRepository {
    suspend fun getActivityInfo(): List<Tickets>{
        return try{
            TicketApi.searchTicket.getTicket().tickets
        } catch ( t:Throwable) {
            println("Ошибка $t")
            emptyList()
        }
    }
}