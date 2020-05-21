package com.app.api

data class RetrofitResult<out T>(val status: Status, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T): RetrofitResult<T> {
            return RetrofitResult(
                Status.SUCCESS,
                data,
                null
            )
        }

        fun <T> error(message: String, data: T? = null): RetrofitResult<T> {
            return RetrofitResult(
                Status.ERROR,
                data,
                message
            )
        }

        fun <T> loading(data: T? = null): RetrofitResult<T> {
            return RetrofitResult(
                Status.LOADING,
                data,
                null
            )
        }
    }
}