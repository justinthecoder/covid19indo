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

    val getMovieEvent = repository.getCovidModelEvent

    private val covid = MutableLiveData<CovidModel>()

    fun getMovie() {
        viewModelScope.async {
            covid.postValue(repository.getMovieList())
        }
    }

    fun getMovieData(): LiveData<CovidModel?> {
        return covid
    }
}