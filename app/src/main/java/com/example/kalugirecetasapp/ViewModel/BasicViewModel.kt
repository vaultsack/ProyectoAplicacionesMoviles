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

    private val _imagenID = MutableLiveData<String>("")
    val imagenID: LiveData<String> = _imagenID

    private val _recetaFavorite = MutableLiveData<Boolean>(false)
    val recetaFavorite: LiveData<Boolean> = _recetaFavorite

    private val _recetaList = MutableLiveData<ArrayList<infoReceta>>(arrayListOf())
    val recetaList: LiveData<ArrayList<infoReceta>> = _recetaList

    private val _selectedReceta = MutableLiveData<infoReceta>()
    val selectedReceta: LiveData<infoReceta> = _selectedReceta

    private val _isGrid = MutableLiveData<Boolean>(true)
    val isGrid: LiveData<Boolean> = _isGrid

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

    fun updateImagenID(newImagenID: String) {
        _imagenID.value = newImagenID
    }

    fun updaterecetaFavorite(newrecetaFavorite: Boolean) {
        _recetaFavorite.value = newrecetaFavorite
    }

    fun updateRecetaList(newRecetaList: ArrayList<infoReceta>, newReceta: infoReceta) {
        newRecetaList.add(newReceta)
        _recetaList.value = newRecetaList
    }

    fun initializedRecetaList(newRecetaList: ArrayList<infoReceta>) {
        _recetaList.value = newRecetaList
    }

    fun updateSelectedReceta(newSelectedReceta: infoReceta) {
        _selectedReceta.value = newSelectedReceta
    }

    fun getGrid(): Boolean? {
        return isGrid.value
    }
    fun setGrid(newGrid: Boolean) {
        _isGrid.value = newGrid





    }
}