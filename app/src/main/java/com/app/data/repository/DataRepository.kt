package com.app.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.app.BuildConfig
import com.app.api.RetrofitResult
import com.app.data.model.TimesResponse
import com.app.data.remoteDataSource.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) {

    fun getTimes(): LiveData<RetrofitResult<TimesResponse>> {
        return liveData(Dispatchers.IO) {
            emit(RetrofitResult.loading(null))

            val response = remoteDataSource.getTimes(BuildConfig.API_KEY)
            if (response.status == RetrofitResult.Status.SUCCESS) {
                response.data?.let { data ->
                    emit(RetrofitResult.success(data))
                }
            } else {
                emit(RetrofitResult.error("Error", null))
            }
        }
    }
}