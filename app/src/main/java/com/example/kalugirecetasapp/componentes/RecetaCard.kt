package com.example.kalugirecetasapp.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kalugirecetasapp.model.Receta

@Composable
fun RecetaCard(
    receta: Receta,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Column {
            Image(
                painter = painterResource(id = receta.imagen),
                contentDescription = receta.nombre,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = receta.nombre,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${receta.tiempoPreparacion} min • ${receta.dificultad}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
} 