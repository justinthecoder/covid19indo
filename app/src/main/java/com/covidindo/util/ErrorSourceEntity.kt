package com.covidindo.util

import androidx.annotation.Keep

@Keep
data class ErrorSourceEntity(
    val type: String?,
    val field: String?,
    val criteria: String?,
    val index: Int?
)