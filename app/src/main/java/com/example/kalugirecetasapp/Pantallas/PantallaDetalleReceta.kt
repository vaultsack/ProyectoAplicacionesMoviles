package com.example.kalugirecetasapp.Pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kalugirecetasapp.ViewModel.BasicViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaDetalleReceta(
    viewModel: BasicViewModel,
    navController: NavController,
    recetaId: String
) {
    val recetas = viewModel.listaRecetas.value ?: emptyList()
    val receta = recetas.find { it.id == recetaId }

    receta?.let { recetaActual ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Box {
                Image(
                    painter = painterResource(id = recetaActual.imagen),
                    contentDescription = recetaActual.nombre,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )

                IconButton(
                    onClick = { navController.navigateUp() },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Volver",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = recetaActual.nombre,
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = recetaActual.descripcion,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                // Ingredientes
                Text(
                    text = "Ingredientes",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                recetaActual.ingredientes.forEach { ingrediente ->
                    Text(
                        text = "• $ingrediente",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }

                // Pasos
                Text(
                    text = "Preparación",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                recetaActual.pasos.forEachIndexed { index, paso ->
                    Text(
                        text = "${index + 1}. $paso",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
            }
        }
    }
} 