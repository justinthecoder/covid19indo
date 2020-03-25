package com.covidindo.network

import com.covidindo.model.CovidModel
import retrofit2.Call
import retrofit2.http.GET


interface RestApiService {

    @GET("indonesia")
    fun getCovidDataInIndonesia(): Call<CovidModel>

}