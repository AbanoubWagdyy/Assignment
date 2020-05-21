package com.app.data.remoteDataSource

import com.app.api.APiService
import com.app.api.BaseDataSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val service: APiService) :
    BaseDataSource() {

    suspend fun getTimes(api_key: String) =
        getResult { service.getTimes(api_key) }
}