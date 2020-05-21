package com.app.ui.homepage

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.app.api.RetrofitResult
import com.app.data.model.TimesResponse
import com.app.data.repository.DataRepository
import javax.inject.Inject

class HomepageVM @Inject constructor(private val mRepo: DataRepository) : ViewModel() {

    fun getTimes(): LiveData<RetrofitResult<TimesResponse>> {
        return mRepo.getTimes()
    }
}