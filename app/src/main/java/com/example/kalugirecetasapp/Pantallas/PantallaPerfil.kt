package com.example.kalugirecetasapp.Pantallas

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.kalugirecetasapp.ViewModel.BasicViewModel
import com.example.kalugirecetasapp.dataClass.infoReceta

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPerfil(
    recetasList: ArrayList<infoReceta>,
    modifier: Modifier = Modifier,
    inViewModel: BasicViewModel,
    navController: NavController
) {
    // Obserwacja ulubionych przepisów i nazwy użytkownika z ViewModel
    val favoriteRecipes = recetasList.filter { it.recetaFavorite }
    val allRecipes = inViewModel.recetaList.observeAsState(arrayListOf()).value
    val userName by inViewModel.userName.observeAsState(initial = "Usuario")
    var editedName by remember { mutableStateOf(userName) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Perfil") }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // Sekcja: Edycja imienia użytkownika
            Text(text = "Nombre:", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = editedName,
                onValueChange = { editedName = it },
                label = { Text("Nombre de Usuario") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    inViewModel.updateUserName(editedName)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Actualizar Nombre")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Sekcja: Ulubione przepisy
            Text(text = "Recetas Favoritas:", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            if (favoriteRecipes.isEmpty()) {
                Text("No tienes recetas favoritas.", style = MaterialTheme.typography.bodyLarge)
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(8.dp)
                ) {
                    items(favoriteRecipes.size) { index ->
                        val recipe = favoriteRecipes[index]
                        Card(
                            modifier = Modifier
                                .padding(8.dp)
                                .clickable {
                                    // Możesz dodać nawigację do szczegółów przepisu
                                },
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Image(
                                    painter = rememberAsyncImagePainter(model = recipe.imagenID),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(100.dp)
                                        .clip(CircleShape),
                                    contentScale = ContentScale.Crop
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(text = recipe.nombreReceta, style = MaterialTheme.typography.bodyLarge)
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Sekcja: Wszystkie przepisy
            Text(text = "Todos tus Recetas:", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            LazyColumn {
                items(allRecipes.size) { index ->
                    val recipe = allRecipes[index]
                    Text(
                        text = "- ${recipe.nombreReceta}",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Przyciski: Zamknij aplikację lub wróć do menu głównego
            Button(
                onClick = {
                    navController.navigate("main_menu")
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            ) {
                Text("Volver al Menú Principal", color = Color.White)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    // Zamknięcie aplikacji
                    System.exit(0)
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text("Cerrar Aplicación", color = Color.White)
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PantallaPerfilPreview() {
    PantallaPerfil(
        recetasList = arrayListOf(),
        inViewModel = BasicViewModel(),
        navController = NavController(LocalContext.current)
    )
}
