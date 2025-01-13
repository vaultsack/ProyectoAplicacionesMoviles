package com.example.kalugirecetasapp.bars

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.kalugirecetasapp.R
import com.example.kalugirecetasapp.dataClass.drawerMenuItem
import com.example.kalugirecetasapp.navegacion.Pantallas
import com.example.kalugirecetasapp.ui.theme.AbrilFatface

@Composable
fun DrawerHeader(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 64.dp),
        contentAlignment = Alignment.Center
    ) {

        Text(
            modifier = Modifier.fillMaxWidth()
                .padding(20.dp),
            text = "Kalugi",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
        )
    }

    Column (modifier = Modifier.fillMaxWidth()
        .padding(20.dp)) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

val items = listOf(
    drawerMenuItem(
        icon = R.drawable.baseline_home_24,
        title = "Inicio",
        route = "receta"
    ),
    drawerMenuItem(
        icon = R.drawable.baseline_search_24,
        title = "Busqueda",
        route = "busqueda"
    ),
    drawerMenuItem(
        icon = R.drawable.baseline_favorite_24,
        title = "Favoritos",
        route = "pantallaFavoritos"
    ),
    drawerMenuItem(
        icon = R.drawable.baseline_library_books_24,
        title = "Tus recetas",
        route = "recetaGrid"
    ),
    drawerMenuItem(
        icon = R.drawable.baseline_add_24,
        title = "Añadir",
        route = "pantalla_añadir"
    ),
    drawerMenuItem(
        icon = R.drawable.baseline_settings_24,
        title = "Configuración",
        route = "pantallaConfiguracion"
    )
)
    }
}
