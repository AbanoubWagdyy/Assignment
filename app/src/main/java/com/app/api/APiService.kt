package com.app.api


import com.app.data.model.TimesResponse
import retrofit2.Response
import retrofit2.http.*

interface APiService {

    @GET("7.json")
    fun getTimes(@Query("api-key") api_key: String): Response<TimesResponse>
}