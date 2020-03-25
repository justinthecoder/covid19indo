package com.covidindo.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CovidModel(
    @SerializedName("cases")
    val totalcases: Int,
    @SerializedName("deaths")
    val confirmedDead: Int,
    @SerializedName("recovered")
    val confirmedHealed: Int,
    @SerializedName("active")
    val confirmedActive: Int
) : Parcelable
