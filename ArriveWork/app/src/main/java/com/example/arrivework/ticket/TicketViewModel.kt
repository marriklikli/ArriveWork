package com.example.arrivework.ticket

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arrivework.Tickets
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TicketViewModel (private val repository: TicketRepository) : ViewModel() {

    private val _data = MutableStateFlow<List<Tickets>>(emptyList())
    val data = _data.asStateFlow()


    fun onGetData () {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                repository.getActivityInfo()
            }.fold(
                onSuccess = {_data.value = it},
                onFailure = { Log.d("Ticket", it.message ?: "")}
            )
        }
    }
}