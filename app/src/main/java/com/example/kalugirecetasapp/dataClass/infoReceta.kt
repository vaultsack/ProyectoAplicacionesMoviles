package com.example.kalugirecetasapp.dataClass

import android.net.Uri

class infoReceta(
    var IDreceta: Uri,
    var nombreReceta: String,
    var ingredientes: String,
    var instrucciones: String,
    var categoria: String,
    var tiempoPreparacion: String,
    var dificultad: String,
    var imagenID: String,
    var recetaFavorite: Boolean=false

)

