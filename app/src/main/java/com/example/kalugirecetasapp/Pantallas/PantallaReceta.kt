package com.example.kalugirecetasapp.Pantallas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.kalugirecetasapp.ViewModel.BasicViewModel
import com.example.kalugirecetasapp.dataClass.infoReceta
import com.example.kalugirecetasapp.recetaList
import java.lang.reflect.Modifier
@Composable
fun Receta(recetaList: ArrayList<infoReceta>, modifier: androidx.compose.ui.Modifier) {
    /* Función que hace lo mismo que PantallaCantante() pero sin ViewModel */

    var selectedReceta by remember { mutableStateOf(recetaList[2]) }
    Column(modifier = modifier) {
        // Crear fila de tarjetas (Cards Row). Corresponde a código en CrearListaCantantes()
        LazyRow(modifier = androidx.compose.ui.Modifier.padding(10.dp)) {
            items(recetaList.size) { index ->
                val receta = recetaList[index] // Pobranie obiektu z listy na podstawie indeksu
                Card(
                    shape = MaterialTheme.shapes.large, // RoundedCornerShape(5.dp)
                    border = BorderStroke(2.dp, Color.DarkGray),
                    modifier = androidx.compose.ui.Modifier
                        .width(150.dp)
                        .height(100.dp)
                        .clickable {
                            selectedReceta = receta
                        }
                ) {
                    Box(
                        modifier = androidx.compose.ui.Modifier.fillMaxSize()
                    ) {
                        // Wyświetlenie obrazu z `imagenID`
                        AsyncImage(
                            model = receta.imagenID, // Poprawne odniesienie do pola `imagenID`
                            contentDescription = receta.nombreReceta, // Poprawne odniesienie do `nombreReceta`
                            contentScale = ContentScale.Crop,
                            modifier = androidx.compose.ui.Modifier.fillMaxSize()
                        )

                        Box(
                            modifier = androidx.compose.ui.Modifier
                                .fillMaxSize()
                                .background(
                                    Brush.verticalGradient(
                                        colors = listOf(
                                            Color.Transparent,
                                            Color.Black
                                        ),
                                        startY = 180f // Gradient dla dolnej części obrazu
                                    )
                                )
                        )
                        Spacer(modifier = androidx.compose.ui.Modifier.size(10.dp))
                        // Wyświetlenie nazwy przepisu
                        Text(
                            text = receta.nombreReceta, // Poprawne odniesienie do `nombreReceta`
                            modifier = androidx.compose.ui.Modifier
                                .padding(6.dp)
                                .align(Alignment.BottomStart),
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = androidx.compose.ui.Modifier.size(30.dp))
                }
            }
        }
    }



        // Crear la vista de la info de la Card seleccionada. Corresponde a código en MostrarInfoCard()
        Column(
            modifier = androidx.compose.ui.Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top

        ) {
            AsyncImage(selectedReceta.imagenID, selectedReceta.nombreReceta,contentScale = ContentScale.Crop)

            Row {
                IconToggleButton(checked = selectedReceta.recetaFavorite == true,
                    onCheckedChange = { selectedReceta.recetaFavorite = it }
                ) {
                    Icon(
                        imageVector =
                        if (selectedReceta.recetaFavorite == true) Icons.Filled.Favorite
                        else Icons.Outlined.FavoriteBorder,
                        contentDescription =
                        if (selectedReceta.recetaFavorite == true) "Favorito" else "No Favorito",
                        tint = Color.Red
                    )
                }
                Text(
                    text = selectedReceta.nombreReceta,
                    modifier = androidx.compose.ui.Modifier
                        .align(Alignment.CenterVertically)
                        .padding(12.dp),
                    fontSize = 36.sp,
                    color = Color.Blue,
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.ExtraBold,
                    fontStyle = FontStyle.Italic
                )
            }
            HorizontalDivider()
            Text(
                text = selectedReceta.ingredientes,
                modifier = androidx.compose.ui.Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(12.dp),
                fontSize = 18.sp,
                color = Color.Black,
                fontStyle = FontStyle.Italic
            )
            HorizontalDivider()
            Text(
                text = selectedReceta.instrucciones,
                modifier = androidx.compose.ui.Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(12.dp),
                fontSize = 18.sp,
                color = Color.Black,
                fontStyle = FontStyle.Italic
            )
        }
    }



@Composable
fun MostrarInfoCard(selectedReceta: infoReceta, inViewModel: BasicViewModel) {

    /* TODO HECHO recibe como parámetro la varaible del tipo ViewModel que utilizará para observar los campos que debe mostrar esta pantalla InfoCard */

    /* TODO definir las variables a observar en el ViewModel */
    LaunchedEffect(key1 = true) { // para que cargue al iniciar la app la info del selectedSinger, aunque nadie haga click en ninguna tarjeta
        inViewModel.updateNombreReceta(selectedReceta.nombreReceta)
        inViewModel.updateImagenID(selectedReceta.imagenID)
        inViewModel.updateInstrucciones(selectedReceta.instrucciones)
        inViewModel.updateIngredientes(selectedReceta.ingredientes)
        inViewModel.updaterecetaFavorite(selectedReceta.recetaFavorite)
        inViewModel.updateSelectedReceta(selectedReceta)
    }

    val selectedReceta by inViewModel.selectedReceta.observeAsState(selectedReceta)

    val imagenID by inViewModel.imagenID.observeAsState(selectedReceta.imagenID)
    val nombreReceta by inViewModel.nombreReceta.observeAsState(selectedReceta.nombreReceta)
    val Ingrediedntes by inViewModel.ingredientes.observeAsState(selectedReceta.ingredientes)
    val Instrucciones by inViewModel.instrucciones.observeAsState(selectedReceta.instrucciones)
    val recetaFavorite by inViewModel.recetaFavorite.observeAsState(selectedReceta.recetaFavorite)



    Column(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top

    ) {
        AsyncImage(imagenID, nombreReceta,contentScale = ContentScale.Crop)

        Row {
            IconToggleButton(checked = recetaFavorite, /* TODO HECHO sustituir selectedCard.singerFavorite por variable que observa en el ViewModel valor Favorito */
                onCheckedChange = {
                    inViewModel.updaterecetaFavorite(it) } /* TODO HECHO sustituir por método del ViewModel que actualiza valor Favorito*/
            ) {
                Icon(
                    imageVector =
                    if (recetaFavorite == true) {
                        Icons.Filled.Favorite
                    }  /* TODO HECHO sustituir selectedCard.singerFavorite por variable que observa en el ViewModel valor Favorito */
                    else Icons.Outlined.FavoriteBorder,
                    contentDescription =
                    if (recetaFavorite == true) "Favorito" else "No Favorito", /* TODO HECHO sustituir selectedCard.singerFavorite por variable que observa en el ViewModel valor Favorito */
                    tint = Color.Red
                )
            }
            Text(
                text = nombreReceta, /* TODO HECHO sustituir selectedCard.singerName por variable que observa en el ViewModel valor singerName */
                modifier = androidx.compose.ui.Modifier
                    .align(Alignment.CenterVertically)
                    .padding(12.dp),
                fontSize = 36.sp,
                color = Color.Blue,
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.ExtraBold,
                fontStyle = FontStyle.Italic
            )
        }
        HorizontalDivider()
        Text(
            text = Ingrediedntes, /* TODO HECHO sustituir selectedCard.albumsName por variable que observa en el ViewModel valor albumsName */
            modifier = androidx.compose.ui.Modifier
                .align(Alignment.CenterHorizontally)
                .padding(12.dp),
            fontSize = 18.sp,
            color = Color.Black,
            //fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Italic
        )
        HorizontalDivider()
        Text(
            text = Instrucciones, /* TODO HECHO sustituir selectedCard.albumSongs por variable que observa en el ViewModel valor albumSongs */
            modifier = androidx.compose.ui.Modifier
                .align(Alignment.CenterHorizontally)
                .padding(12.dp),
            fontSize = 18.sp,
            color = Color.Black,
            //fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Italic
        )
    }
}

@Composable
fun CrearCardReceta(receta: infoReceta, inViewModel: BasicViewModel,navController: NavController) {

    /* TODO recibe como parámetro la varaible del tipo ViewModel donde guardar los datos de la tarjeta en la que el usuario a clicado */
    /* TODO si queremos que la pantalla de información se muestre en otra activity y no debajo de la lista de cards, como por ejemplo cuando se llama a PantallaCantanteGrid()
       deberá recibirse tambien el NavController, para incluir la navegación a MostrarInfoCard() en el atributo .clickable de la Card.
     */
    /*  Esta función añadie navegación en el atributo .clickable de la Card, si ha sido llamada desde PantallaCantanteGrid() */

    Card(shape = MaterialTheme.shapes.large,//RoundedCornerShape(5.dp),
        border = BorderStroke(2.dp, Color.DarkGray),
        modifier = androidx.compose.ui.Modifier
            .width(150.dp)
            .height(100.dp)

            .clickable {
                /* TODO HECHO guardar Card aseleccionada en variable ViewModel */
                inViewModel.updateSelectedReceta(receta)

                /* TODO HECHO guardar los valores de la tarjeta seleccionada en variables ViewModel */
                inViewModel.updateNombreReceta(receta.nombreReceta)
                inViewModel.updateImagenID(receta.imagenID)
                inViewModel.updateInstrucciones(receta.instrucciones)
                inViewModel.updateIngredientes(receta.ingredientes)
                inViewModel.updaterecetaFavorite(receta.recetaFavorite)


                /*TODO incluir navegación a MostrarInfoCard() si se llama desde PantallaCantanteGrid()*/
                if (inViewModel.getGrid()==true) {

                    navController.navigate("cardInfo")

                }
            }

    ) {
        Box(
            modifier = androidx.compose.ui.Modifier
                .fillMaxSize()

        ) {
            //se utilizara el parámetro de entrada cantante, porque no es necesario observar cambios en el ViewModel,
            // ya que no se produrián al no estar asocida a ningún evento la llamada de esta función
            AsyncImage(receta.imagenID,
                receta.nombreReceta,
                contentScale = ContentScale.Crop,
                modifier = androidx.compose.ui.Modifier
                    .fillMaxSize()
            )

            Box(
                modifier = androidx.compose.ui.Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 160f
                        )
                    )
            )
            Spacer(modifier = androidx.compose.ui.Modifier.size(10.dp))
            Text(
                text = receta.nombreReceta,
                modifier = androidx.compose.ui.Modifier
                    .padding(6.dp)
                    .align(Alignment.BottomStart),
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold

            )


        }
        Spacer(modifier= androidx.compose.ui.Modifier.size(10.dp))
    }
}

@Composable  //----------- ESTA FUNCIÓN NO FUNCIONA SIN ViewModel ---------------
fun PantallaReceta(recetaList:ArrayList<infoReceta>, modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier, inViewModel: BasicViewModel, navController: NavController) {
    /* TODO HECHO: recibe como parámetro la varaible del tipo ViewModel para pasarla como parámetro a CrearCardCantante y MostrarInfoCard() */
    inViewModel.setGrid(false)

    val selectedReceta by inViewModel.selectedReceta.observeAsState(recetaList[0]) /* TODO con ViewModel sutituir la variable por la variable de ViewModel*/

    Column(modifier = modifier

    ) {
        LazyRow (modifier = androidx.compose.ui.Modifier.padding(10.dp)){
            items(recetaList){ index->
                CrearCardReceta(index,inViewModel,navController)
                Spacer(modifier= androidx.compose.ui.Modifier.size(6.dp))
            }
        }
        Spacer(modifier = androidx.compose.ui.Modifier.size(30.dp))
        MostrarInfoCard(selectedReceta,inViewModel) /* TODO con ViewModel sutituir la variable por la variable de ViewModel*/
    }
}



@Composable
fun PantallaRecetaGrid(recetaList: ArrayList<infoReceta>, modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier, inViewModel: BasicViewModel, navController: NavController) {
    /* TODO recibe como parámetro la varaible del tipo ViewModel para pasarla como parámetro a CrearCardCantante y MostrarInfoCard() */

    inViewModel.setGrid(true)

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        modifier = androidx.compose.ui.Modifier.padding(10.dp)

    ) {
        items(recetaList.size) { index ->
            CrearCardReceta(recetaList[index],inViewModel,navController)
            Spacer(modifier = androidx.compose.ui.Modifier.size(6.dp))
        }
    }
}
