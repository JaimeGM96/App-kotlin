package com.example.jaime.pruebakotlin.Rest

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit



/**
 * Created by jaime on 20/3/18.
 */
class ApiClient {
    val BASE_URL = "https://randomuser.me/api/"

    val URL_API = "http://192.168.1.111:8080/api/"

    fun getClient(): ApiInterface {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(ApiInterface::class.java)
    }

    fun getStundent(): ApiInterface {
        val retrofit = Retrofit.Builder()
                .baseUrl(URL_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(ApiInterface::class.java)
    }
}