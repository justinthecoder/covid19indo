package com.covidindo.util

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
</T> */
data class Resource<out T>(
    val status: Status,
    val data: T?,
    val exception: Exception?,
    val errorMessage: String?,
    val errors: List<ErrorMessageEntity>?
) {
    companion object {
        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(
                Status.LOADING,
                data,
                null,
                null,
                null
            )
        }

        fun <T> success(data: T?): Resource<T> {
            return Resource(
                Status.SUCCESS,
                data,
                null,
                null,
                null
            )
        }

        fun <T> error(errorMessage: String, data: T? = null): Resource<T> {
            return Resource(
                Status.ERROR,
                data,
                null,
                errorMessage,
                null
            )
        }

        fun <T> error(exception: Exception, data: T? = null): Resource<T> {
            return Resource(
                Status.ERROR,
                data,
                exception,
                null,
                null
            )
        }

        fun <T> error(errors: List<ErrorMessageEntity>, data: T? = null): Resource<T> {
            return Resource(
                Status.ERROR,
                data,
                null,
                null,
                errors
            )
        }
    }
}
