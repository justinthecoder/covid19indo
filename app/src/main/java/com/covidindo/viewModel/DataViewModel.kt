package com.covidindo.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.covidindo.repository.DataRepository
import kotlinx.coroutines.async

class DataViewModel(
    context: Application,
    val repository: DataRepository
) : AndroidViewModel(context) {

    val getCovidDataEvent = repository.getCovidDataEvent

    fun triggerFetchFromBackend() {
        viewModelScope.async {
            repository.getCovidData()
        }
    }
}