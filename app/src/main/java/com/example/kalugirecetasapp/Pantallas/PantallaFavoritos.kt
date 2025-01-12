package com.example.kalugirecetasapp.Pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.kalugirecetasapp.ViewModel.BasicViewModel
import com.example.kalugirecetasapp.dataClass.infoReceta
@Composable
fun PantallaFavoritos(
    recetaList: List<infoReceta>,
    modifier: Modifier = Modifier,
    inViewModel: BasicViewModel,
    navController: NavController
) {}
//    // Filtrujemy przepisy oznaczone jako ulubione
//    val favoriteRecipes = recetaList.filter { it.recetaFavorite }
//
//    Column(modifier = modifier.fillMaxSize()) {
//        Text(
//            text = "Recetas Favoritas",
//            style = MaterialTheme.typography.headlineMedium,
//            modifier = Modifier.padding(16.dp)
//        )
//
//        if (favoriteRecipes.isEmpty()) {
//            // Wyświetlamy wiadomość, jeśli nie ma ulubionych przepisów
//            Text(
//                text = "No tienes recetas favoritas.",
//                style = MaterialTheme.typography.bodyLarge,
//                modifier = Modifier.padding(16.dp)
//            )
//        } else {
//            // Wyświetlamy ulubione przepisy w gridzie
//            LazyVerticalGrid(
//                columns = GridCells.Fixed(2),
//                contentPadding = PaddingValues(16.dp),
//                verticalArrangement = Arrangement.spacedBy(8.dp),
//                horizontalArrangement = Arrangement.spacedBy(8.dp)
////            ) {
//                items(favoriteRecipes) { receta ->
//                    Card(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .clickable {
//                                // Nawigacja do szczegółów przepisu
//                                navController.navigate("detalle_receta/${receta.infoReceta}")
//                            },
//                        shape = RoundedCornerShape(8.dp),
//                        elevation = CardDefaults.cardElevation(4.dp)
//                    ) {
//                        Column(
//                            modifier = Modifier.padding(8.dp),
//                            horizontalAlignment = Alignment.CenterHorizontally
//                        ) {
//                            Image(
//                                painter = rememberAsyncImagePainter(model = receta.imagenID),
//                                contentDescription = receta.nombreReceta,
//                                modifier = Modifier
//                                    .size(120.dp)
//                                    .clip(RoundedCornerShape(8.dp)),
//                                contentScale = ContentScale.Crop
//                            )
//                            Spacer(modifier = Modifier.height(8.dp))
//                            Text(
//                                text = receta.nombreReceta,
//                                style = MaterialTheme.typography.bodyLarge,
//                                modifier = Modifier.align(Alignment.CenterHorizontally),
//                                maxLines = 1
//                            )
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
