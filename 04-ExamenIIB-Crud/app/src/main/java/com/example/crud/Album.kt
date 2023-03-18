package com.example.crud

data class Album (
    var id: String = "",
    var nombre: String = "",
    var duracion: Double = 0.0,
    var fechaLanzamiento: String = "",
    var esLanzamiento: Boolean? = null
        )