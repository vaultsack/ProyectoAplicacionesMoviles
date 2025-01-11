package com.example.kalugirecetasapp.Pantallas

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.kalugirecetasapp.ViewModel.BasicViewModel
import com.example.kalugirecetasapp.dataClass.infoReceta

@Composable
fun PantallaFavoritos(recetaList: ArrayList<infoReceta>, modifier: Modifier, inViewModel: BasicViewModel) {
    val favorito by inViewModel.recetaFavorite.observeAsState(false)

}