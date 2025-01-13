package com.example.kalugirecetasapp.Pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
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
fun PantallaReceta(viewModel: BasicViewModel, navController: NavController, recetaId: String) {
    val receta = viewModel.obtenerRecetaPorId(recetaId)
    var isFavorite by remember { mutableStateOf(receta?.esFavorito ?: false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(receta?.nombre ?: "") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                },
                actions = {
                    IconButton(onClick = { isFavorite = !isFavorite }) {
                        Icon(
                            if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = "Favorito"
                        )
                    }
                }
            )
        }
    ) { padding ->
        receta?.let { recetaActual ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .verticalScroll(rememberScrollState())
            ) {
                Image(
                    painter = painterResource(id = recetaActual.imagen),
                    contentDescription = recetaActual.nombre,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )

                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = recetaActual.descripcion,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    // Información básica
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        InfoItem("Tiempo", "${recetaActual.tiempoPreparacion} min")
                        InfoItem("Porciones", "${recetaActual.porciones}")
                        InfoItem("Dificultad", recetaActual.dificultad)
                    }

                    Divider(modifier = Modifier.padding(vertical = 16.dp))

                    // Ingredientes
                    Text(
                        text = "Ingredientes",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    recetaActual.ingredientes.forEach { ingrediente ->
                        Text(
                            text = "• $ingrediente",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }

                    Divider(modifier = Modifier.padding(vertical = 16.dp))

                    // Pasos
                    Text(
                        text = "Preparación",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(bottom = 8.dp)
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
}

@Composable
private fun InfoItem(label: String, value: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}