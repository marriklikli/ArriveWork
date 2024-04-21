package com.example.arrivework.country

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arrivework.ticketsoffers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CountryViewModel (private val repository: CountryRepository) : ViewModel() {

    private val _data = MutableStateFlow<List<ticketsoffers>>(emptyList())
    val data = _data.asStateFlow()


    fun onGetData() {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                repository.getActivityInfo()
            }.fold(
                onSuccess = { _data.value = it },
                onFailure = { Log.d("Ticket", it.message ?: "") }
            )
        }
    }
}
