package com.example.jaime.pruebakotlin.model.randomUserAPI

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by jaime on 20/3/18.
 */
data class Name(
        @SerializedName("title") val title: String = "",
        @SerializedName("first") val first: String = "",
        @SerializedName("last") val last: String = ""
) : Serializable