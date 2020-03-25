package com.covidindo.repository

import android.app.Application
import com.covidindo.model.CovidModel
import com.covidindo.network.RetrofitInstance
import com.covidindo.util.Resource
import com.covidindo.util.SingleLiveEvent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.suspendCoroutine

/**
 * We use coroutines to handle callback function.
 */
class DataRepository(val context: Application) {

    val getCovidDataEvent = SingleLiveEvent<Resource<CovidModel>>()
    suspend fun getCovidData() {
        return suspendCoroutine {
            getCovidDataEvent.postValue(Resource.loading())
            val apiService = RetrofitInstance.getApiService
            val call = apiService.getCovidDataInIndonesia()

            call.enqueue(object : Callback<CovidModel> {
                override fun onFailure(call: Call<CovidModel>, t: Throwable) {
                    getCovidDataEvent.postValue(Resource.error("something went wrong"))
                }

                override fun onResponse(call: Call<CovidModel>, response: Response<CovidModel>) {
                    val result = response.body()
                    if (result != null) {
                        getCovidDataEvent.postValue(Resource.success(result))
                    } else {
                        getCovidDataEvent.postValue(Resource.error("wkwkwk"))
                    }
                }
            })
        }
    }
}