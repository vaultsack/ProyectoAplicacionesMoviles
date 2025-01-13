package com.example.kalugirecetasapp.bars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.kalugirecetasapp.Pantallas.PantallaAñadir
import com.example.kalugirecetasapp.navegacion.Pantallas

@Composable
fun AppBottomBar(navController: NavController) {
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val items = listOf(
            Triple("Inicio", Icons.Default.Home, Pantallas.PantallaInicio.route),
            Triple("Buscar", Icons.Default.Search, Pantallas.PantallaBusqueda.route),
            Triple("Favoritos", Icons.Default.Favorite, Pantallas.PantallaFavoritos.route),
            Triple("Perfil", Icons.Default.Person, Pantallas.PantallaPerfil.route)
        )

        items.forEach { (title, icon, route) ->
            NavigationBarItem(
                icon = { Icon(icon, contentDescription = title) },
                label = { Text(title) },
                selected = currentRoute == route,
                onClick = {
                    if (currentRoute != route) {
                        navController.navigate("añadir") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                }
            )
        }
    }
}