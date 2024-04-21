package com.example.arrivework.first

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelRepository : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewMadol::class.java)) {
            return MainViewMadol(Repository()) as T
        }
        throw IllegalArgumentException("Неизвестно")
    }
}