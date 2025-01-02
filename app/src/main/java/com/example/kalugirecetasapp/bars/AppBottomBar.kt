package com.example.kalugirecetasapp.bars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import java.lang.reflect.Modifier

@Composable
fun BottomNavigationBar(navController: NavController) {
    val selectedItem = remember { mutableStateOf(0) }
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") },
            label = { Text("Inicio") },
            selected = (selectedItem.value == 0),
            onClick = { /*TODO navegar a pantalla inicio*/ }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Search, contentDescription = "Búsqueda") },
            label = { Text("Búsqueda") },
            selected = (selectedItem.value == 1),
            onClick = { /*TODO navegar a pantalla busqueda*/ }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Favorite, contentDescription = "Favoritos") },
            label = { Text("Favoritos") },
            selected = (selectedItem.value == 2),
            onClick = { /*TODO navegar a pantalla favoritos*/ }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") },
            label = { Text("Perfil") },
            selected = (selectedItem.value == 3),
            onClick = { /*TODO navegar a pantalla perfil*/ }
        )
    }
}
@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigationBar(navController = NavController(LocalContext.current))
}


//    Scaffold(
//        floatingActionButton = {
//            FloatingActionButton(onClick = { navController.navigate("pantalla_anadir") }) {
//                Icon(Icons.Default.Add, contentDescription = "Añadir Receta")
//            }
//        },
//        bottomBar = {
//            NavigationBar {
//                NavigationBarItem(
//                    icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") },
//                    label = { Text("Inicio") },
//                    selected = (selectedItem.value == 0),
//                    onClick = {
//                        selectedItem.value = 0
//                        navController.navigate("pantalla_inicio") // Przejście do PantallaInicio
//                    }
//                )
//                NavigationBarItem(
//                    icon = { Icon(Icons.Default.Search, contentDescription = "Búsqueda") },
//                    label = { Text("Búsqueda") },
//                    selected = (selectedItem.value == 1),
//                    onClick = {
//                        selectedItem.value = 1
//                        navController.navigate("pantalla_busqueda") // Przejście do PantallaBusqueda
//                    }
//                )
//                NavigationBarItem(
//                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Favoritos") },
//                    label = { Text("Favoritos") },
//                    selected = (selectedItem.value == 2),
//                    onClick = {
//                        selectedItem.value = 2
//                        navController.navigate("pantalla_favoritos") // Przejście do PantallaFavoritos
//                    }
//                )
//                NavigationBarItem(
//                    icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") },
//                    label = { Text("Perfil") },
//                    selected = (selectedItem.value == 3),
//                    onClick = {
//                        selectedItem.value = 3
//                        navController.navigate("pantalla_perfil") // Przejście do PantallaPerfil
//                    }
//                )
//            }
//        }
//}