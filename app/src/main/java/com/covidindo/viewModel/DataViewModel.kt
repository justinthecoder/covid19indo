package com.covidindo.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.covidindo.model.ListMovieWrapper
import com.covidindo.repository.DataRepository
import kotlinx.coroutines.async

class DataViewModel(
    context: Application,
    val repository: DataRepository
) : AndroidViewModel(context) {

    val getMovieEvent = repository.getListMovieWrapperEvent

    private val covid = MutableLiveData<ListMovieWrapper>()

    fun getMovie() {
        viewModelScope.async {
            covid.postValue(repository.getMovieList())
        }
    }

    fun getMovieData(): LiveData<ListMovieWrapper?> {
        return covid
    }
}