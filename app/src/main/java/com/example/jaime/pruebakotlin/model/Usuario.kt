package com.example.jaime.pruebakotlin.model

import java.io.Serializable

/**
 * Created by jaime on 19/3/18.
 */
 data class Usuario(
        var login:String,
        var password:String,
        var nombre:String,
        var apellido: String
) : Serializable