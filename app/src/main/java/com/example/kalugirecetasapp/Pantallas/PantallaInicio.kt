package com.example.kalugirecetasapp.Pantallas

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kalugirecetasapp.ViewModel.BasicViewModel
import com.example.kalugirecetasapp.componentes.RecetaCard
import com.example.kalugirecetasapp.navegacion.Pantallas
import com.example.kalugirecetasapp.ui.theme.Purple80
import androidx.annotation.DrawableRes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaInicio(viewModel: BasicViewModel, navController: NavController) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(Pantallas.PantallaAnadir.route) },
                containerColor = Purple80
            ) {
                Icon(Icons.Default.Add, contentDescription = "Anadir receta")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(viewModel.categorias) { categoria ->
                    CategoryChip(
                        icon = categoria.icon,
                        label = categoria.nombre,
                        onClick = { /* TODO: Filtrar por categoría */ }
                    )
                }
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(viewModel.listaRecetas.value ?: emptyList()) { receta ->
                    RecetaCard(
                        receta = receta,
                        onClick = { navController.navigate("receta/${receta.id}") }
                    )
                }
            }
        }
    }
}

@Composable
fun CategoryChip(
    @DrawableRes icon: Int,
    label: String,
    onClick: () -> Unit
) {
    FilterChip(
        selected = false,
        onClick = onClick,
        label = { Text(label) },
        leadingIcon = {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
    )
}