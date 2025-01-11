package com.example.kalugirecetasapp.Pantallas
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.kalugirecetasapp.ViewModel.BasicViewModel
import com.example.kalugirecetasapp.dataClass.infoReceta

@Composable
fun PantallaConfiguracion(
    recetaViewModel: ArrayList<infoReceta> = viewModel(),
    onResetRecetas: Modifier,
    onToggleDarkMode: BasicViewModel,
    onChangeLanguage: NavHostController
) {
    var isDarkMode by remember { mutableStateOf(false) }
    var selectedLanguage by remember { mutableStateOf("Español") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header
        Text(
            text = "Configuración",
            style = MaterialTheme.typography.headlineLarge
        )

        // Reset Recipes Button
        Button(
            onClick = {
                onResetRecetas()
                recetaViewModel.initializedRecetaList(arrayListOf())
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Resetear Recetas")
        }

        // Dark Mode Toggle
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Modo Oscuro")
            Switch(
                checked = isDarkMode,
                onCheckedChange = {
                    isDarkMode = it
                    onToggleDarkMode(it)
                }
            )
        }

        // Language Selector
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Idioma")
            DropdownMenuExample(
                selectedLanguage = selectedLanguage,
                onLanguageSelected = {
                    selectedLanguage = it
                    onChangeLanguage(it)
                }
            )
        }
    }
}

@Composable
fun DropdownMenuExample(selectedLanguage: String, onLanguageSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val languages = listOf("Español", "Inglés", "Francés")

    Box(modifier = Modifier.fillMaxWidth()) {
        OutlinedButton(
            onClick = { expanded = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(selectedLanguage)
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            languages.forEach { language ->
                DropdownMenuItem(
                    text = { Text(language) },
                    onClick = {
                        onLanguageSelected(language)
                        expanded = false
                    }
                )
            }
        }
    }
}


