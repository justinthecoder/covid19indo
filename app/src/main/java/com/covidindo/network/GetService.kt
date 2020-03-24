package com.covidindo.network

import retrofit2.Call
import retrofit2.http.GET


interface GetService {
    @get:GET("/confirmed")
    val allPhotos: Call<List<Any?>?>?
}