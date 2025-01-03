package com.example.kalugirecetasapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.kalugirecetasapp.ViewModel.BasicViewModel
import com.example.kalugirecetasapp.bars.AppTopBarConDrawer
import com.example.kalugirecetasapp.bars.BottomNavigationBar
import com.example.kalugirecetasapp.bars.DrawerHeader
import com.example.kalugirecetasapp.dataClass.drawerMenuItem
import com.example.kalugirecetasapp.dataClass.infoReceta
import com.example.kalugirecetasapp.navegacion.Navegacion
import com.example.kalugirecetasapp.ui.theme.KalugiRecetasAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KalugiRecetasAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val appViewModel by viewModels<BasicViewModel>()
                    InitRecetaList(appViewModel)
                    PantallaInicio(
                        modifier = Modifier.padding(innerPadding),
                        appViewModel
                    )
                }
            }
        }
    }
}
var recetaList = arrayListOf<infoReceta>()


@Composable
fun InitRecetaList(inViewModel: BasicViewModel) {
    val uriDumplings =
        "https://az.przepisy.pl/www-przepisy-pl/www.przepisy.pl/przepisy3ii/img/variants/800x0/chinskie-pierozki-dim-sum-2.jpg"

    val dumplingsIngredientes = stringResource(R.string.DumplingsIngediente)
    val dumplingsInstrucciones = stringResource(R.string.DumplingsInstruccion)

    val initialRecetaList = arrayListOf(
        infoReceta(
            IDreceta = "1",
            nombreReceta = "Dumplings",
            categoria = "Cena",
            tiempoPreparacion = "45 minutos",
            dificultad = "Media",
            ingredientes = dumplingsIngredientes,
            instrucciones = dumplingsInstrucciones,
            imagen = uriDumplings,
            favorito = false
        )
    )
    inViewModel.initializeRecetaList(initialRecetaList)
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PantallaInicio(modifier: Modifier = Modifier,inViewModel: BasicViewModel) {

    val navController = rememberNavController()
    val recetaList by inViewModel.recetaList.observeAsState(arrayListOf())

    val menuItems = arrayListOf(
        drawerMenuItem(
            icon = R.drawable.baseline_home_24,
            title = "Inicio",
            route = "pantallaInicio"
        ),
        drawerMenuItem(
            icon = R.drawable.baseline_search_24,
            title = "Busqueda",
            route = "pantallaBusqueda"
        ),
        drawerMenuItem(
            icon = R.drawable.baseline_favorite_24,
            title = "Favoritos",
            route = "pantallaFavoritos"
        ),
        drawerMenuItem(
            icon = R.drawable.baseline_library_books_24,
            title = "Tus recetas",
            route = "pantallaTusRecetas"
        ),
        drawerMenuItem(
            icon = R.drawable.baseline_add_24,
            title = "Añadir",
            route = "pantallaAnadir"
        ),
        drawerMenuItem(
            icon = R.drawable.baseline_settings_24,
            title = "Configuración",
            route = "pantallaConfiguracion"
        )
    )


    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                DrawerHeader()
                Spacer(modifier = Modifier.padding(12.dp))
                menuItems.forEachIndexed { index, menuItems ->
                    NavigationDrawerItem(
                        label = { Text(text = menuItems.title) },
                        onClick = {
                            selectedItemIndex = index
                            navController.navigate(menuItems.route)
                            scope.launch {
                                drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        },
                        selected = selectedItemIndex == index,
                        icon = {
                            Icon(
                                imageVector = ImageVector.vectorResource(menuItems.icon),
                                contentDescription = menuItems.title
                            )
                        }
                    )
                }

            }
        },
        gesturesEnabled = false
    ) {
        Scaffold(
            topBar = { AppTopBarConDrawer("KalugiRecetasApp", scope, drawerState) },
            bottomBar = { BottomNavigationBar(navController) },
            floatingActionButton = {
                ExtendedFloatingActionButton(

                    onClick = { navController.navigate("addReceta")},
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_add_24),
                        contentDescription = "Agregar"
                    )
                }
            }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {

                Navegacion(navController, recetaList, modifier, inViewModel)

            }

        }

    }
}

