package com.example.kalugirecetasapp.Pantallas

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kalugirecetasapp.ViewModel.BasicViewModel
import com.example.kalugirecetasapp.componentes.RecetaCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaBusqueda(viewModel: BasicViewModel, navController: NavController) {
    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Buscar recetas...") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) }
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            val recetas = viewModel.listaRecetas.value ?: emptyList()
            items(recetas.filter {
                it.nombre.contains(searchQuery, ignoreCase = true)
            }) { receta ->
                RecetaCard(
                    receta = receta,
                    onClick = { navController.navigate("receta/${receta.id}") }
                )
            }
        }
    }
}
