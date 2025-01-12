package com.example.kalugirecetasapp.Pantallas

import android.annotation.SuppressLint
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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.kalugirecetasapp.ViewModel.BasicViewModel
import com.example.kalugirecetasapp.bars.TopBarBuscar
import com.example.kalugirecetasapp.dataClass.infoReceta


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PantallaBusqueda(listaFiachas: ArrayList<infoReceta>, modifier: Modifier = Modifier, inViewModel: BasicViewModel,navController: NavController) {
    val palabraABuscar = remember { mutableStateOf(TextFieldValue("")) }
    Column(
        modifier = modifier,
    ){
        TopBarBuscar(palabraABuscar)
        BuscarEnLista(palabraABuscar,listaFiachas,modifier,inViewModel,navController)
    }
}

@Composable
fun BuscarEnLista(palabraABuscar: MutableState<TextFieldValue>, listaRecetas:ArrayList<infoReceta>, modifier: Modifier = Modifier, inViewModel: BasicViewModel, navController: NavController)
{
    var listaFiltrada = listaRecetas
    val textABuscar = palabraABuscar.value.text

    listaFiltrada = if (textABuscar.isEmpty()) listaRecetas
    else {
        val resultList = ArrayList<infoReceta>()
        for (singer in listaRecetas){
            if (singer.nombreReceta.lowercase().contains(textABuscar.lowercase(),true)){
                resultList.add(singer)
            }
        }
        resultList
    }

    /* Llamada si se utiliza sin ViewModel
    Cantante(listaFiltrada,modifier.padding(start = 10.dp)) */

    PantallaReceta(listaFiltrada,modifier.padding(start = 10.dp),inViewModel, navController )

}
