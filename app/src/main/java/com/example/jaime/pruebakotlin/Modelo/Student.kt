package com.example.jaime.pruebakotlin.Modelo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Student(
        @SerializedName("name") val name: String = "",
        @SerializedName("lastName") val lastName: String = "",
        @SerializedName("lastName2") val lastName2: String = "",
        @SerializedName("age") val age: Int = 0,
        @SerializedName("group") val group: Group = Group()
) : Serializable