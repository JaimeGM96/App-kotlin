package com.example.jaime.pruebakotlin.model.schoolAPI

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Student(
        @SerializedName("name") val name: String = "",
        @SerializedName("lastname") val lastName: String = "",
        @SerializedName("lastname2") val lastName2: String = "",
        @SerializedName("age") val age: Int = 0,
        @SerializedName("group") val group: String = "",
        @SerializedName("came") val came: Boolean = false
) : Serializable