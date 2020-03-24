package com.covidindo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private var retrofit: Retrofit? = null
    val BASE_URL =
        "https://wuhan-coronavirus-api.laeyoung.endpoint.ainize.ai/jhu-edu/"
//    latest?iso2=ID/
    val getApiService: RestApiService
        get() {
            if (retrofit == null) {

                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            }
            return retrofit!!.create(RestApiService::class.java)
        }
}