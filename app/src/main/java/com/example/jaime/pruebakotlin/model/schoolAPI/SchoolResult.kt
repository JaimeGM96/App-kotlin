package com.example.jaime.pruebakotlin.model.schoolAPI

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SchoolResult(
        @SerializedName("student") val student: Student = Student()
) : Serializable