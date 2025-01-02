package com.example.kalugirecetasapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kalugirecetasapp.dataClass.infoReceta

class BasicViewModel:ViewModel() {

    private val _IDreceta = MutableLiveData<String>("")
    val IDreceta: LiveData<String> = _IDreceta


    private val _nombreReceta = MutableLiveData<String>("")
    val nombreReceta: LiveData<String> = _nombreReceta

    private val _categoria = MutableLiveData<String>("")
    val categoria: LiveData<String> = _categoria

    private val _tiempoPreparacion = MutableLiveData<String>("")
    val tiempoPreparacion: LiveData<String> = _tiempoPreparacion

    private val _dificultad = MutableLiveData<String>("")
    val dificultad: LiveData<String> = _dificultad

    private val _ingredientes = MutableLiveData<String>("")
    val ingredientes: LiveData<String> = _ingredientes

    private val _instrucciones = MutableLiveData<String>("")
    val instrucciones: LiveData<String> = _instrucciones

    private val _imagen = MutableLiveData<String>("")
    val imagen: LiveData<String> = _imagen

    private val _favorito = MutableLiveData<Boolean>(false)
    val favorito: LiveData<Boolean> = _favorito

    private val _recetaList = MutableLiveData<ArrayList<infoReceta>>(arrayListOf())
    val recetaList: LiveData<ArrayList<infoReceta>> = _recetaList

    private val _selectedReceta = MutableLiveData<infoReceta>()
    val selectedReceta: LiveData<infoReceta> = _selectedReceta

    fun updateIDreceta(newIDreceta: String) {
        _IDreceta.value = newIDreceta
    }

    fun updateNombreReceta(newNombreReceta: String) {
        _nombreReceta.value = newNombreReceta
    }

    fun updateCategoria(newCategoria: String) {
        _categoria.value = newCategoria
    }

    fun updateTiempoPreparacion(newTiempoPreparacion: String) {
        _tiempoPreparacion.value = newTiempoPreparacion
    }

    fun updateDificultad(newDificultad: String) {
        _dificultad.value = newDificultad
    }

    fun updateIngredientes(newIngredientes: String) {
        _ingredientes.value = newIngredientes
    }

    fun updateInstrucciones(newInstrucciones: String) {
        _instrucciones.value = newInstrucciones
    }

    fun updateImagen(newImagen: String) {
        _imagen.value = newImagen
    }

    fun updateFavorito(newFavorito: Boolean) {
        _favorito.value = newFavorito
    }

    fun updateRecetaList(newRecetaList: ArrayList<infoReceta>, newReceta: infoReceta) {
        newRecetaList.add(newReceta)
        _recetaList.value = newRecetaList
    }

    fun initializeRecetaList(newRecetaList: ArrayList<infoReceta>) {
        _recetaList.value = newRecetaList
    }

    fun updateSelectedReceta(newSelectedReceta: infoReceta) {
        _selectedReceta.value = newSelectedReceta
    }

    fun updateRecetaList(newRecetaList: ArrayList<infoReceta>) {
        _recetaList.value = newRecetaList



    }
}