package com.example.kalugirecetasapp.navegacion

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kalugirecetasapp.Pantallas.PantallaBusqueda
import com.example.kalugirecetasapp.Pantallas.PantallaConfiguracion
import com.example.kalugirecetasapp.ViewModel.BasicViewModel
import com.example.kalugirecetasapp.dataClass.infoReceta


@Composable
fun Navegacion(navController: NavHostController, recetalrist:ArrayList<infoReceta>, modifier:Modifier, inViewModel: BasicViewModel) {
    val selectedReceta by inViewModel.selectedReceta.observeAsState(recetalrist[0])

    NavHost(navController = navController, startDestination = "pantalla_inicio") {
        composable("busqueda") { PantallaBusqueda(recetalrist, modifier, inViewModel,navController) }

    }
}
