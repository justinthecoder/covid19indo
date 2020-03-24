package com.covidindo.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

//class ListMovieWrapper {
//
////    @SerializedName("results")
////    private var mData: CovidModel? = null
////
////    fun getDetail(): CovidModel? {
////        return mData
////    }
//
//    @SerializedName("confirmed")
//    private val totalcases: Int? = null
//    @SerializedName("deaths")
//    val confirmedDead: Int? = null
//    @SerializedName("recovered")
//    val confirmedHealed: Int? = null
//
//}

@Parcelize
data class ListMovieWrapper(
    @SerializedName("confirmed")
    val totalcases: Int,
    @SerializedName("deaths")
    val confirmedDead: Int,
    @SerializedName("recovered")
    val confirmedHealed: Int
) : Parcelable
