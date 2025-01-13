package com.example.kalugirecetasapp.model

data class Receta(
    val id: String,
    val nombre: String,
    val imagen: Int,
    val descripcion: String,
    val ingredientes: List<String>,
    val pasos: List<String>,
    val tiempoPreparacion: Int,
    val porciones: Int,
    val dificultad: String,
    val categoria: String,
    val esFavorito: Boolean = false
) 