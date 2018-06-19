package com.example.jaime.pruebakotlin.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by jaime on 20/3/18.
 */
data class Id(
        @SerializedName("name") val name: String = "",
        @SerializedName("value") val value: String = ""
) : Serializable