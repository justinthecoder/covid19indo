package com.covidindo.network

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiCaller : Application() {
    var retrofit: Retrofit? = null
    val BASE_URL = "https://wuhan-coronavirus-api.laeyoung.endpoint.ainize.ai/jhu-edu/latest?iso2=ID"

    fun getRetrofitInstance(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }
}