package com.example.kalugirecetasapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.annotation.DrawableRes
import com.example.kalugirecetasapp.ViewModel.BasicViewModel
import com.example.kalugirecetasapp.navegacion.Pantallas
import com.example.kalugirecetasapp.ui.theme.KalugiRecetasAppTheme
import com.example.kalugirecetasapp.bars.*
import com.example.kalugirecetasapp.Pantallas.*
import androidx.compose.material3.DrawerValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.kalugirecetasapp.ui.theme.Purple80
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kalugirecetasapp.dataClass.drawerMenuItem
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KalugiRecetasAppTheme {
                val viewModel: BasicViewModel by viewModels()
                MainContent(viewModel)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent(viewModel: BasicViewModel) {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val menuItems = arrayListOf(
        drawerMenuItem(
            icon = R.drawable.baseline_home_24,
            title = "Inicio",
            route = "inicio"
        ),
        drawerMenuItem(
            icon = R.drawable.baseline_search_24,
            title = "Busqueda",
            route = "busqueda"
        ),
        drawerMenuItem(
            icon = R.drawable.baseline_favorite_24,
            title = "Favoritos",
            route = "favoritos"
        ),
        drawerMenuItem(
            icon = R.drawable.baseline_library_books_24,
            title = "Tus recetas",
            route = "inicio"
        ),
        drawerMenuItem(
            icon = R.drawable.baseline_add_24,
            title = "Añadir",
            route = "anadir"
        ),
        drawerMenuItem(
            icon = R.drawable.baseline_settings_24,
            title = "Configuración",
            route = "configuracion"
        )
    )

    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                DrawerHeader(navController)
                Spacer(modifier = Modifier.padding(12.dp))
                menuItems.forEachIndexed { index, menuItems ->
                    NavigationDrawerItem(
                        label = { Text(text = menuItems.title) },
                        onClick = {
                            selectedItemIndex = index
                            navController.navigate(menuItems.route)
                            scope.launch {
                                drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        },
                        selected = selectedItemIndex == index,
                        icon = {
                            Icon(
                                imageVector = ImageVector.vectorResource(menuItems.icon),
                                contentDescription = menuItems.title
                            )
                        }
                    )
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                AppTopBar(
                    title = "KalugiRecetas",
                    drawerState = drawerState,
                    navController = navController
                )
            },
            bottomBar = {
                AppBottomBar(navController = navController)
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Pantallas.PantallaInicio.route,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(Pantallas.PantallaInicio.route) {
                    PantallaInicio(viewModel, navController)
                }
                composable(Pantallas.PantallaBusqueda.route) {
                    PantallaBusqueda(viewModel, navController)
                }
                composable(Pantallas.PantallaFavoritos.route) {
                    PantallaFavoritos(viewModel, navController)
                }
                composable(Pantallas.PantallaPerfil.route) {
                    PantallaPerfil(viewModel, navController)
                }
                composable(Pantallas.PantallaAnadir.route){
                    PantallaAñadir(viewModel, navController)
                }
                composable(Pantallas.PantallaConfiguracion.route){
                    PantallaConfiguracion(viewModel, navController)
                }
                composable(
                    route = Pantallas.PantallaReceta.route
                ) { backStackEntry ->
                    val recetaId = backStackEntry.arguments?.getString("recetaId")
                    if (recetaId != null) {
                        PantallaDetalleReceta(viewModel, navController, recetaId)
                    }
                }
            }
        }
    }
}

