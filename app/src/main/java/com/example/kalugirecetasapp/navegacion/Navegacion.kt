package com.example.kalugirecetasapp.navegacion

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kalugirecetasapp.PantallaInicio
import com.example.kalugirecetasapp.Pantallas.PantallaAddReceta
import com.example.kalugirecetasapp.Pantallas.PantallaBusqueda
import com.example.kalugirecetasapp.Pantallas.PantallaConfiguracion
import com.example.kalugirecetasapp.Pantallas.PantallaFavoritos
import com.example.kalugirecetasapp.ViewModel.BasicViewModel
import com.example.kalugirecetasapp.dataClass.infoReceta


@Composable
fun Navegacion(navController: NavHostController, recetaList:ArrayList<infoReceta>, modifier:Modifier, inViewModel: BasicViewModel) {
    val selectedReceta by inViewModel.selectedReceta.observeAsState(recetaList[0])

    NavHost(navController = navController, startDestination = "pantalla_inicio") {
        composable("busqueda") { PantallaBusqueda(recetaList, modifier, inViewModel,navController) }
        composable("pantalla_inicio") { PantallaInicio( recetaList, modifier) }
        composable("pantalla_configuracion") { PantallaConfiguracion(recetaList, modifier, inViewModel,navController) }
        composable("pantalla_anadir") { PantallaAddReceta(recetaList, modifier, inViewModel,navController) }

        composable("pantalla_favoritos") { PantallaFavoritos (selectedReceta,inViewModel) }




    }

}
