package com.example.kalugirecetasapp.navegacion

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kalugirecetasapp.PantallaInicio
import com.example.kalugirecetasapp.Pantallas.MostrarInfoCard
import com.example.kalugirecetasapp.Pantallas.PantallaAddReceta
import com.example.kalugirecetasapp.Pantallas.PantallaBusqueda
import com.example.kalugirecetasapp.Pantallas.PantallaFavoritos
import com.example.kalugirecetasapp.Pantallas.PantallaReceta
import com.example.kalugirecetasapp.Pantallas.PantallaRecetaGrid
import com.example.kalugirecetasapp.ViewModel.BasicViewModel
import com.example.kalugirecetasapp.dataClass.infoReceta


@Composable
fun Navegacion(navController: NavHostController, recetasList:ArrayList<infoReceta>, modifier:Modifier, inViewModel: BasicViewModel) {
    val selectedReceta by inViewModel.selectedReceta.observeAsState(recetasList[0])

    NavHost(navController = navController, startDestination = "receta") {
        composable("busqueda") { PantallaBusqueda(recetasList, modifier, inViewModel,navController) }
        composable("receta") { PantallaReceta(recetasList, modifier, inViewModel,navController) }
        composable("recetaGrid") { PantallaRecetaGrid(recetasList, modifier, inViewModel,navController) }
        composable("pantalla_anadir") { PantallaAddReceta(recetasList, modifier, inViewModel,navController) }
        composable("cardInfo") { MostrarInfoCard(selectedReceta, inViewModel)}




    }

}
