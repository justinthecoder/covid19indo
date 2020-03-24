package com.covidindo.network

import com.covidindo.model.ListMovieWrapper
import retrofit2.Call
import retrofit2.http.GET


interface RestApiService {

    @GET("latest?iso2=ID")
    fun popularMovie(): Call<List<ListMovieWrapper>>

}