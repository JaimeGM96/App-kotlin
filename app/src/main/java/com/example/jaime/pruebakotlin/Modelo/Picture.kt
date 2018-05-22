package com.example.jaime.pruebakotlin.Modelo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by jaime on 20/3/18.
 */
data class Picture(
        @SerializedName("large") val large: String = "",
        @SerializedName("medium") val medium: String = "",
        @SerializedName("thumbnail") val thumbnail: String = ""
) : Serializable