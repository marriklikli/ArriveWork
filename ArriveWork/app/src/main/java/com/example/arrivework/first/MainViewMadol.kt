package com.example.arrivework.first

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arrivework.offers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewMadol (private val repository: Repository) : ViewModel() {

    private val _data = MutableStateFlow<List<offers>>(emptyList())
    val data = _data.asStateFlow()


    fun onGetData () {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                repository.getActivityInfo()
            }.fold(
                onSuccess = {_data.value = it},
                onFailure = { Log.d("Music", it.message ?: "")}
            )
        }
    }

}