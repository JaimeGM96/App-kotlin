package com.example.jaime.pruebakotlin.Modelo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by jaime on 20/3/18.
 */
data class Info(
        @SerializedName("seed") val seed: String = "",
        @SerializedName("results") val results: Int = 0,
        @SerializedName("page") val page: Int = 0,
        @SerializedName("version") val version: String = ""
) : Serializable