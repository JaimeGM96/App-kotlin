package com.example.jaime.pruebakotlin.Rest

import com.example.jaime.pruebakotlin.model.ApiResponse
import com.example.jaime.pruebakotlin.model.ApiResponseSchool
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by jaime on 20/3/18.
 */
interface ApiInterface {
    @GET("?results=20")
    fun getUsers(@Query("numUsers") numUsers: String): Call<ApiResponse>

    @GET("?group=1")
    fun getStudents(@Query("numUsers") numUsers: String): Call<ApiResponseSchool>

    @GET("start/1")
    fun startClass(): Call<ApiResponseSchool>
}