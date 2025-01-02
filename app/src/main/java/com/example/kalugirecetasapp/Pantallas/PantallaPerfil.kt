package com.example.kalugirecetasapp.Pantallas

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.kalugirecetasapp.ViewModel.BasicViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPerfil(
    viewModel: BasicViewModel,
    userName: String,
    onNameChange: (String) -> Unit,
    onLogOut: () -> Unit,
    onDeleteAccount: () -> Unit
) {
    val favoriteRecipes = viewModel.recetaList.value?.filter { it.favorito } ?: emptyList()
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
            // User Name
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
                    onNameChange(editedName)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Actualizar Nombre")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Favorite Recipes
            Text(text = "Recetas Favoritas:", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            if (favoriteRecipes.isEmpty()) {
                Text("No tienes recetas favoritas.", style = MaterialTheme.typography.headlineMedium)
            } else {
                favoriteRecipes.forEach { recipe ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                    ) {
                        Row(
                            modifier = Modifier.padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter(model = recipe.imagen),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(64.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Color.LightGray),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Column {
                                Text(text = recipe.nombreReceta, style = MaterialTheme.typography.headlineMedium)
                                Text(
                                    text = "Categoría: ${recipe.categoria}",
                                    style = MaterialTheme.typography.headlineMedium,
                                    color = Color.Gray
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Log Out Button
            Button(
                onClick = { onLogOut() },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors()
            ) {
                Text("Cerrar Sesión", color = Color.White)
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Delete Account Button
            Button(
                onClick = { onDeleteAccount() },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors()
            ) {
                Text("Cerrar Cuenta", color = Color.White)
            }
        }
    }
}
