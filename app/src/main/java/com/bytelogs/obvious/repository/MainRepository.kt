package com.bytelogs.obvious.repository

import android.util.Log
import com.bytelogs.obvious.model.ApodResponse
import androidx.lifecycle.MutableLiveData
import com.bytelogs.obvious.model.ApiInterface
import javax.inject.Inject

class MainRepository @Inject constructor(var  apiInterface: ApiInterface): SafeApiRequest() {


    private val apods = MutableLiveData<List<ApodResponse>>()
    private val apiKey:String = "BpcLKUigWU22AdMBzIySUMv5vYNDqsrGArjGhmfM"



      suspend fun fetchApods(startDate:String, endDate:String):MutableLiveData<List<ApodResponse>> {

          try {

                val response = apiRequest {apiInterface.getNasaApod(startDate,endDate,apiKey)}
                apods.postValue(response)


            } catch (e: Exception) {
                e.printStackTrace()
            }

         return apods
    }



}