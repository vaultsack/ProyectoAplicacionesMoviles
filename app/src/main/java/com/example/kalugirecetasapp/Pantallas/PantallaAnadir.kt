package com.example.kalugirecetasapp.Pantallas

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kalugirecetasapp.ViewModel.BasicViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaAñadir(viewModel: BasicViewModel, navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var ingredientes by remember { mutableStateOf("") }
    var pasos by remember { mutableStateOf("") }
    var tiempo by remember { mutableStateOf("") }
    var porciones by remember { mutableStateOf("") }
    var dificultad by remember { mutableStateOf("") }
    var categoria by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Añadir Nueva Receta") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre de la receta") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = descripcion,
                onValueChange = { descripcion = it },
                label = { Text("Descripción") },
                modifier = Modifier.fillMaxWidth(),
                minLines = 3
            )

            OutlinedTextField(
                value = ingredientes,
                onValueChange = { ingredientes = it },
                label = { Text("Ingredientes (uno por línea)") },
                modifier = Modifier.fillMaxWidth(),
                minLines = 4
            )

            OutlinedTextField(
                value = pasos,
                onValueChange = { pasos = it },
                label = { Text("Pasos de preparación (uno por línea)") },
                modifier = Modifier.fillMaxWidth(),
                minLines = 4
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OutlinedTextField(
                    value = tiempo,
                    onValueChange = { tiempo = it },
                    label = { Text("Tiempo (min)") },
                    modifier = Modifier.weight(1f)
                )

                OutlinedTextField(
                    value = porciones,
                    onValueChange = { porciones = it },
                    label = { Text("Porciones") },
                    modifier = Modifier.weight(1f)
                )
            }

            OutlinedTextField(
                value = dificultad,
                onValueChange = { dificultad = it },
                label = { Text("Dificultad") },
                modifier = Modifier.fillMaxWidth()
            )

            ExposedDropdownMenuBox(
                expanded = false,
                onExpandedChange = { },
            ) {
                OutlinedTextField(
                    value = categoria,
                    onValueChange = { },
                    readOnly = true,
                    label = { Text("Categoría") },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Button(
                onClick = {
                    // TODO: Implementar lógica para guardar la receta
                    navController.navigateUp()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Default.Add, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Guardar Receta")
            }
        }
    }
}