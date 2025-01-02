package com.example.kalugirecetasapp.Pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.kalugirecetasapp.ViewModel.BasicViewModel
import java.lang.reflect.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaReceta(viewModel: BasicViewModel, recetaId: String, onBack: () -> Unit) {
    val receta = viewModel.recetaList.value?.find { it.IDreceta == recetaId }

    if (receta == null) {
        Text(
            "Receta no encontrada",
            textAlign = TextAlign.Center,
            modifier = androidx.compose.ui.Modifier.fillMaxSize()
        )
        return
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(receta.nombreReceta) },
                navigationIcon = {
                    IconButton(onClick = { onBack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = androidx.compose.ui.Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            // Recipe Image
            receta.imagen.takeIf { it.isNotEmpty() }?.let { imageUrl ->
                Image(
                    painter = rememberAsyncImagePainter(model = imageUrl),
                    contentDescription = "Imagen de ${receta.nombreReceta}",
                    modifier = androidx.compose.ui.Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
            } ?: Box(
                modifier = androidx.compose.ui.Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                Text("Sin imagen disponible", color = Color.Gray)
            }

            Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))

            // Recipe Details
            Text(
                text = "Categoría: ${receta.categoria}",
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = "Tiempo de preparación: ${receta.tiempoPreparacion}",
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = "Dificultad: ${receta.dificultad}",
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))

            // Ingredients
            Text(
                text = "Ingredientes:",
                style = MaterialTheme.typography.bodyLarge
            )
            receta.ingredientes.forEach { ingredient ->
                Text(
                    text = "- $ingredient",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
