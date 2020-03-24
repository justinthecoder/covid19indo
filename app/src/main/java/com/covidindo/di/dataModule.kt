package com.covidindo.di

import com.covidindo.repository.DataRepository
import com.covidindo.viewModel.DataViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {

    viewModel {
        DataViewModel(
            context = androidApplication(),
            repository = get()
        )
    }

    single {
        DataRepository(
            context = androidApplication()
        )
    }

}