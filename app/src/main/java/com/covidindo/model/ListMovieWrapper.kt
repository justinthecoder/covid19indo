package com.covidindo.model

import com.google.gson.annotations.SerializedName

class ListMovieWrapper {

//    @SerializedName("results")
//    private var mData: CovidModel? = null
//
//    fun getDetail(): CovidModel? {
//        return mData
//    }

    @SerializedName("confirmed")
    private val totalcases: Int? = null
    @SerializedName("deaths")
    val confirmedDead: Int? = null
    @SerializedName("recovered")
    val confirmedHealed: Int? = null

}
