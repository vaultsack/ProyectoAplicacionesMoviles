package com.example.kalugirecetasapp.Pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.kalugirecetasapp.ViewModel.BasicViewModel
import com.example.kalugirecetasapp.dataClass.infoReceta

@Composable
fun PantallaBusqueda(onSearch: ArrayList<infoReceta>, modifier: Modifier, inViewModel: BasicViewModel, navController: NavHostController) {
    val searchQuery = remember { mutableStateOf("") }
    val selectedFilters = remember { mutableStateOf(mutableSetOf<String>()) }

    val filterOptions = listOf(
        "DULCE", "SALADO",
        "TIEMPO corto", "TIEMPO medio", "TIEMPO largo",
        "HORNO", "SARTÉN", "MICROONDAS",
        "CARNE", "VEGETA",
        "DESAYUNO", "COMIDA", "MERIENDA", "CENA",
        "SIN GLUTEN"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        OutlinedTextField(
            value = searchQuery.value,
            onValueChange = { searchQuery.value = it },
            label = { Text("Buscar receta") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Buscar"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )


        Text(
            text = "Filtros de búsqueda:",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        LazyColumn {
            items(filterOptions) { filter ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = selectedFilters.value.contains(filter),
                        onCheckedChange = {
                            if (it) {
                                selectedFilters.value.add(filter)
                            } else {
                                selectedFilters.value.remove(filter)
                            }
                        }
                    )
                    Text(text = filter, modifier = Modifier.padding(start = 8.dp))
                }
            }
        }


        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Text("Buscar")
        }
    }
}
