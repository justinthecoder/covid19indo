package com.covidindo.repository

import android.app.Application
import com.covidindo.model.CovidModel
import com.covidindo.network.RetrofitInstance
import com.covidindo.util.Resource
import com.covidindo.util.SingleLiveEvent
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

            call.enqueue(object : Callback<List<CovidModel>> {
                override fun onFailure(call: retrofit2.Call<List<CovidModel>>, t: Throwable) {
                    getCovidDataEvent.postValue(Resource.error("something went wrong"))
                }

                override fun onResponse(
                    call: retrofit2.Call<List<CovidModel>>,
                    response: Response<List<CovidModel>>
                ) {
                    val result = response.body()
                    if (!result.isNullOrEmpty()) {
                        val covidModel = result[0]
                        getCovidDataEvent.postValue(Resource.success(covidModel))
                    } else {
                        getCovidDataEvent.postValue(Resource.error("wkwkwk"))
                    }
                }
            })
        }
    }
}