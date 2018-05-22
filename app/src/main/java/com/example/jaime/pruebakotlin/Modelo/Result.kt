package com.example.jaime.pruebakotlin.Modelo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by jaime on 20/3/18.
 */
data class Result(
        @SerializedName("gender") val gender: String = "",
        @SerializedName("name") val name: Name = Name(),
        @SerializedName("location") val location: Location = Location(),
        @SerializedName("email") val email: String = "",
        @SerializedName("login") val login: Login = Login(),
        @SerializedName("dob") val dob: String = "",
        @SerializedName("registered") val registered: String = "",
        @SerializedName("phone") val phone: String = "",
        @SerializedName("cell") val cell: String = "",
        @SerializedName("id") val id: Id = Id(),
        @SerializedName("picture") val picture: Picture = Picture(),
        @SerializedName("nat") val nat: String = ""
) : Serializable