package com.example.jaime.pruebakotlin.Modelo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by jaime on 20/3/18.
 */
data class ApiResponse(
        @SerializedName("results") val results: List<Result> = listOf(),
        @SerializedName("info") val info: Info = Info()
) : Serializable