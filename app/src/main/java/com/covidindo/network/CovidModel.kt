package com.covidindo.network

import androidx.core.app.NotificationCompat
import com.google.gson.annotations.SerializedName

data class CovidModel (
//    [{"provincestate":"","countryregion":"Indonesia","lastupdate":"2020-03-23T09:42:00.015Z","location":{"lat":-0.7893,"lng":113.9213},"countrycode":{"iso2":"ID","iso3":"IDN"},"confirmed":514,"deaths":48,"recovered":29}]
    @SerializedName ("confirmed")
    val totalcases:Int,
    @SerializedName ("deaths")
    val confirmedDead:Int,
    @SerializedName ("recovered")
    val confirmedHealed:Int
)