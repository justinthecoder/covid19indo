package com.covidindo.repository

import android.app.Application
import com.covidindo.model.ListMovieWrapper
import com.covidindo.network.RetrofitInstance
import com.covidindo.util.Resource
import com.covidindo.util.SingleLiveEvent
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * We use coroutines to handle callback function.
 */
class DataRepository(val context: Application) {

    val getListMovieWrapperEvent = SingleLiveEvent<Resource<ListMovieWrapper>>()

    suspend fun getMovieList(): ListMovieWrapper {
        return suspendCoroutine { cont ->
            getListMovieWrapperEvent.postValue(Resource.loading())
            val apiService = RetrofitInstance.getApiService
            val call = apiService.popularMovie()

            call.enqueue(object : Callback<List<ListMovieWrapper>> {
                override fun onFailure(call: retrofit2.Call<List<ListMovieWrapper>>, t: Throwable) {
                    getListMovieWrapperEvent.postValue(Resource.error("something went wrong"))
                    cont.resumeWithException(t)
                }

                override fun onResponse(
                    call: retrofit2.Call<List<ListMovieWrapper>>,
                    response: Response<List<ListMovieWrapper>>
                ) {
                    val listMovie = response.body()
                    if (listMovie != null) {
//                        val movies = listMovie.getDetail()
//                        getListMovieWrapperEvent.postValue(Resource.success(movies))
//                        cont.resume(listMovie.getDetail()!!)
                    }
                }
            })
        }
    }
}