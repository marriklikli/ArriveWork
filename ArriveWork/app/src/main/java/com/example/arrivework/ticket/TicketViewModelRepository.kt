package com.example.arrivework.ticket

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class TicketViewModelRepository : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TicketViewModel::class.java)) {
            return TicketViewModel(TicketRepository()) as T
        }
        throw IllegalArgumentException("Неизвестно")
    }
}