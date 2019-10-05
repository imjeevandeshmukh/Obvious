package com.bytelogs.obvious.model

import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Query


interface ApiInterface {
    @GET("/planetary/apod")
    suspend fun getNasaApod(@Query("start_date") start_date: String,@Query("end_date") end_date: String,@Query("api_key") api_key: String) : Response<MutableList<ApodResponse>>

}