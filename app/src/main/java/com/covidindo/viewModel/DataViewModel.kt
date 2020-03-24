package com.covidindo.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.covidindo.model.CovidModel
import com.covidindo.repository.DataRepository
import kotlinx.coroutines.async

class DataViewModel(
    context: Application,
    val repository: DataRepository
) : AndroidViewModel(context) {

    val getCovidDataEvent = repository.getCovidDataEvent

    private val covid = MutableLiveData<CovidModel>()

    fun triggerFetchFromBackend() {
        viewModelScope.async {
            val a = repository.getCovidData()
            val b = a
            covid.postValue(b)
        }
    }

    fun getData(): LiveData<CovidModel?> {
        return covid
    }
}