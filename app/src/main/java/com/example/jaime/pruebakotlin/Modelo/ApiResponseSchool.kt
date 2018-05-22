package com.example.jaime.pruebakotlin.Modelo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ApiResponseSchool(
        @SerializedName("results") val results: List<SchoolResult> = listOf()
) : Serializable