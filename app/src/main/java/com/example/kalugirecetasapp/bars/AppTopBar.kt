package com.example.kalugirecetasapp.bars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import com.example.kalugirecetasapp.navegacion.Pantallas
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: String,
    drawerState: DrawerState? = null,
    navController: NavController,
    showSettingsButton: Boolean = true
) {
    val scope = rememberCoroutineScope()

    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            if (drawerState != null) {
                IconButton(onClick = {
                    scope.launch {
                        drawerState.open()
                    }
                }) {
                    Icon(Icons.Default.Menu, contentDescription = "Menu")
                }
            }
        },
        actions = {
            if (showSettingsButton) {
                IconButton(onClick = {
                    navController.navigate(Pantallas.PantallaConfiguracion.route)
                }) {
                    Icon(Icons.Default.Settings, contentDescription = "Configuración")
                }
            }
        }
    )
}
