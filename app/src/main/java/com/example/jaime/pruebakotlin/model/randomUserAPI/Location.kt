package com.example.jaime.pruebakotlin.model.randomUserAPI

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by jaime on 20/3/18.
 */
data class Location(
        @SerializedName("street") val street: String = "",
        @SerializedName("city") val city: String = "",
        @SerializedName("state") val state: String = "",
        @SerializedName("postcode") val postcode: Int = 0
): Serializable