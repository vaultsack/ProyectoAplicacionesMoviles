package com.example.kalugirecetasapp.dataClass

data class infoReceta(
    val id: String,
    val nombre: String,
    val imagen: Int,
    val tiempoPreparacion: String,
    val dificultad: String,
    val porciones: Int,
    val ingredientes: List<String>,
    val pasos: List<String>,
    val esFavorito: Boolean = false,
    val esDestacada: Boolean = false
)

