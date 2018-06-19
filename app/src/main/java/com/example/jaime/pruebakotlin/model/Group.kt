package com.example.jaime.pruebakotlin.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Group(
        @SerializedName("name") val name: String = ""
        ) : Serializable