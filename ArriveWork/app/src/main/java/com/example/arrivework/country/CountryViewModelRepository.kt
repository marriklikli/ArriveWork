package com.example.arrivework.country

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class CountryViewModelRepository : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CountryViewModel::class.java)) {
            return CountryViewModel(CountryRepository()) as T
        }
        throw IllegalArgumentException("Неизвестно")
    }
}