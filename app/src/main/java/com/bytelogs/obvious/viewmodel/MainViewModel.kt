package com.bytelogs.obvious.viewmodel

import com.bytelogs.obvious.model.ApodResponse
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bytelogs.obvious.repository.MainRepository
import javax.inject.Inject


class MainViewModel @Inject constructor(val mainRepository: MainRepository): ViewModel() {

    suspend fun  onFetchApods(startDate:String, endDate:String):LiveData<List<ApodResponse>> {
       return  mainRepository.fetchApods(startDate,endDate)
    }



 }