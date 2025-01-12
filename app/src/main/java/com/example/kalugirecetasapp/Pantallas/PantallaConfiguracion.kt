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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kalugirecetasapp.ViewModel.BasicViewModel
import com.example.kalugirecetasapp.dataClass.infoReceta

@Composable
fun PantallaConfiguracion(
    inViewModel: BasicViewModel,
    navController: NavHostController
) {
    val isDarkMode by inViewModel.isDarkMode.observeAsState(false)
    val selectedLanguage by inViewModel.selectedLanguage.observeAsState("Español")

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

        //Reset Recipes Button
        Button(
            onClick = {
                inViewModel.resetRecetas()
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
                    inViewModel.toggleDarkMode(it)
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
                    inViewModel.changeLanguage(it)
                }
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Back to Home Button
        Button(
            onClick = { navController.navigate("home") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver al Inicio")
        }
    }
}

@Composable
fun DropdownMenuExample(selectedLanguage: String, onLanguageSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val languages = listOf("Español", "Inglés")

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

// Navigation Integration
@Composable
fun SetupNavGraph(navController: NavHostController, inViewModel: BasicViewModel) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            // Your Home Screen Here
        }
        composable("configuracion") {
            PantallaConfiguracion(
                inViewModel = inViewModel,
                navController = navController
            )
        }
    }
}