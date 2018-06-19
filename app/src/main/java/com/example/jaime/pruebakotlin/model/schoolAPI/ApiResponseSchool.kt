package com.example.jaime.pruebakotlin.model.schoolAPI

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ApiResponseSchool(
        @SerializedName("students") val results: List<SchoolResult> = listOf()
) : Serializable