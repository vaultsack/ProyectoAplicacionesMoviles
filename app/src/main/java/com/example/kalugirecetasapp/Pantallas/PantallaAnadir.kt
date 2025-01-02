package com.example.kalugirecetasapp.Pantallas

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.kalugirecetasapp.R
import com.example.kalugirecetasapp.ViewModel.BasicViewModel
import com.example.kalugirecetasapp.dataClass.infoReceta
import com.example.kalugirecetasapp.recetaList

@Composable
fun PantallaAddReceta(recetaList: ArrayList<infoReceta>, modifier: Modifier, inViewModel: BasicViewModel, navController: NavHostController) {

    LaunchedEffect(key1 = true) {
        inViewModel.updateNombreReceta("")
        inViewModel.updateIngredientes("")
        inViewModel.updateInstrucciones("")
        inViewModel.updateFavorito(false)

    }
    val imagenID by inViewModel.imagen.observeAsState("")
    val nombreReceta:String by inViewModel.nombreReceta.observeAsState("")
    val ingredientes:String by inViewModel.ingredientes.observeAsState("")
    val instrucciones:String by inViewModel.instrucciones.observeAsState("")
    val favorito:Boolean by inViewModel.favorito.observeAsState(false)

    val uriAddReceta = Uri.parse("android.resource://com.example.contactos/drawable/baseline_cookie_24")

    var imageUri by remember{ mutableStateOf<Uri?>(uriAddReceta) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()){
            uri: Uri? ->
        imageUri = uri
        inViewModel.updateImagen(imageUri.toString())
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top=70.dp)
            ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                modifier = Modifier
                    .size(80.dp)
                    .border(0.5.dp, Color.Blue, CircleShape)
                    .padding(1.dp)
                    .clip(RectangleShape)
                    .clickable { launcher.launch("image/*") }
                ,
                contentScale= ContentScale.Crop,
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(imageUri)
                        .build()
                ),
                contentDescription = nombreReceta
            )
            Spacer(modifier = Modifier.size(10.dp))
            OutlinedTextField(value = nombreReceta,
                onValueChange ={inViewModel.updateNombreReceta(it)} ,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                label = { Text(text = "nombre Receta") }
            )

            OutlinedTextField(value = ingredientes,
                onValueChange ={inViewModel.updateIngredientes(it)} ,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                label = { Text(text = "Ingredientes") }
            )

            OutlinedTextField(value = instrucciones,
                onValueChange ={inViewModel.updateInstrucciones(it)} ,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                label = { Text(text = "Instrucciones") }
            )

            IconToggleButton(checked = favorito==true,
                onCheckedChange = {inViewModel.updateFavorito(it)} ) {
                Icon(painter = painterResource(id =
                if (favorito==true) R.drawable.baseline_favorite_24
                else R.drawable.baseline_favorite_border_24
                ),
                    contentDescription =
                    if (favorito==true) "Favorito seleccionado"
                    else "Favorito no seleccionado",
                    tint = Color.Blue
                )
            }
            val newList by inViewModel.recetaList.observeAsState(recetaList)
            Button(onClick = {

                var nuevaReceta = infoReceta( IDreceta = "1", nombreReceta = nombreReceta, categoria = "Cena", tiempoPreparacion = "45 minutos", dificultad = "Media", ingredientes = ingredientes, instrucciones = instrucciones, imagen = imagenID, favorito = favorito)
                inViewModel.updateRecetaList(ArrayList(newList), nuevaReceta )


                navController.navigate("cancion")

            },
                modifier = Modifier
                    .fillMaxWidth(),

                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                enabled= nombreReceta.isNotBlank() &&  ingredientes.isNotBlank()
            ) {
                Text(text = "Añadir nueva Receta",
                    color = Color.White
                )
            }
        }
    }
}
