package com.example.kalugirecetasapp

import android.annotation.SuppressLint
import android.net.Uri
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
    //imagenes

    val uriSpagettiCarboanra = Uri.parse("android.resource://com.example.kalugirecetasapp/drawable/spaghetticarbonara")
    val uriSushiMaki = Uri.parse("android.resource://com.example.kalugirecetasapp/drawable/sushimaki")
    val uriTacosAlPastor = Uri.parse("android.resource://com.example.kalugirecetasapp/drawable/tacospastor")
    val uriPaellaDeMariscosos = Uri.parse("android.resource://com.example.kalugirecetasapp/drawable/paellademarisco")
    val uriRatatouilles = Uri.parse("android.resource://com.example.kalugirecetasapp/drawable/rattatouille")
    val uriPadThai = Uri.parse("android.resource://com.example.kalugirecetasapp/drawable/padthai")
    val uriBroscht = Uri.parse("android.resource://com.example.kalugirecetasapp/drawable/borscht")
    val uriCerviche = Uri.parse("android.resource://com.example.kalugirecetasapp/drawable/ceviche")
    val uriFalafel = Uri.parse("android.resource://com.example.kalugirecetasapp/drawable/falafel")
    val uriBaklava = Uri.parse("android.resource://com.example.kalugirecetasapp/drawable/baklava")
    val uriButterChicken = Uri.parse("android.resource://com.example.kalugirecetasapp/drawable/butterchicken")
    val uriPoutine = Uri.parse("android.resource://com.example.kalugirecetasapp/drawable/poutine")
    val uriDimSum = Uri.parse("android.resource://com.example.kalugirecetasapp/drawable/dimsum")
    val uriFeijoada = Uri.parse("android.resource://com.example.kalugirecetasapp/drawable/feijoada")
    val uriKimchiJjigae = Uri.parse("android.resource://com.example.kalugirecetasapp/drawable/kimchijjigae")
    val uriShepherdsPie = Uri.parse("android.resource://com.example.kalugirecetasapp/drawable/shepherdspie")
    val uriChurros = Uri.parse("android.resource://com.example.kalugirecetasapp/drawable/churros")
    val uriRamen =      Uri.parse("android.resource://com.example.kalugirecetasapp/drawable/ramen")
    val uriGnocchi = Uri.parse("android.resource://com.example.kalugirecetasapp/drawable/gnocchi")
    val uriTabule = Uri.parse("android.resource://com.example.kalugirecetasapp/drawable/tabule")

    //ingredientes desde Strings.xml
    val uriIngredientesSpagettiCarboanra = stringResource(R.string.ingredientesSpagettiCarboanra)
    val uriIngredientesSushiMaki = stringResource(R.string.ingredientesSushiMaki)
    val uriIngredientesTacosAlPastor = stringResource(R.string.ingredientesTacosAlPastor)
    val uriIngredientesPaellaDeMariscosos = stringResource(R.string.ingredientesPaellaDeMariscosos)
    val uriIngredientesRatatouilles = stringResource(R.string.ingredientesRatatouilles)
    val uriIngredientesPadThai = stringResource(R.string.ingredientesPadThai)
    val uriIngredientesBroscht = stringResource(R.string.ingredientesBroscht)
    val uriIngredientesCerviche = stringResource(R.string.ingredientesCerviche)
    val uriIngredientesFalafel = stringResource(R.string.ingredientesFalafel)
    val uriIngredientesBaklava = stringResource(R.string.ingredientesBaklava)
    val uriIngredientesButterChicken = stringResource(R.string.ingredientesButterChicken)
    val uriIngredientesPoutine = stringResource(R.string.ingredientesPoutine)
    val uriIngredientesDimSum = stringResource(R.string.ingredientesDimSum)
    val uriIngredientesFeijoada = stringResource(R.string.ingredientesFeijoada)
    val uriIngredientesKimchiJjigae = stringResource(R.string.ingredientesKimchiJjigae)
    val uriIngredientesShepherdsPie = stringResource(R.string.ingredientesShepherdsPie)
    val uriIngredientesChurros = stringResource(R.string.ingredientesChurros)
    val uriIngredientesRamen = stringResource(R.string.ingredientesRamen)
    val uriIngredientesGnocchi = stringResource(R.string.ingredientesGnocchi)
    val uriIngredientesTabule = stringResource(R.string.ingredientesTabule)

    //Instrucciones desde Strings.xml
    val uriInstruccionesSpagettiCarboanra = stringResource(R.string.instruccionesSpagettiCarboanra)
    val uriInstruccionesSushiMaki = stringResource(R.string.instruccionesSushiMaki)
    val uriInstruccionesTacosAlPastor = stringResource(R.string.instruccionesTacosAlPastor)
    val uriInstruccionesPaellaDeMariscosos = stringResource(R.string.instruccionesPaellaDeMariscosos)
    val uriInstruccionesRatatouilles = stringResource(R.string.instruccionesRatatouilles)
    val uriInstruccionesPadThai = stringResource(R.string.instruccionesPadThai)
    val uriInstruccionesBroscht = stringResource(R.string.instruccionesBroscht)
    val uriInstruccionesCerviche = stringResource(R.string.instruccionesCerviche)
    val uriInstruccionesFalafel = stringResource(R.string.instruccionesFalafel)
    val uriInstruccionesBaklava = stringResource(R.string.instruccionesBaklava)
    val uriInstruccionesButterChicken = stringResource(R.string.instruccionesButterChicken)
    val uriInstruccionesPoutine = stringResource(R.string.instruccionesPoutine)
    val uriInstruccionesDimSum = stringResource(R.string.instruccionesDimSum)
    val uriInstruccionesFeijoada = stringResource(R.string.instruccionesFeijoada)
    val uriInstruccionesKimchiJjigae = stringResource(R.string.instruccionesKimchiJjigae)
    val uriInstruccionesShepherdsPie = stringResource(R.string.instruccionesShepherdsPie)
    val uriInstruccionesChurros = stringResource(R.string.instruccionesChurros)
    val uriInstruccionesRamen = stringResource(R.string.instruccionesRamen)
    val uriInstruccionesGnocchi = stringResource(R.string.instruccionesGnocchi)
    val uriInstruccionesTabule = stringResource(R.string.instruccionesTabule)

    //tiempopreparacion

    //dificultad

    //



    //Lista inicial de Recetas
    var initialRecetaList = arrayListOf<infoReceta>(
        infoReceta( uriSpagettiCarboanra.toString(),"Spagetti Carbonara", uriIngredientesSpagettiCarboanra, uriInstruccionesSpagettiCarboanra, "Cena", "45 minutos", "Media", "spagetticarbonara", true),
        infoReceta( uriSushiMaki.toString(),"Sushi Maki", uriIngredientesSushiMaki, uriInstruccionesSushiMaki, "Cena", "45 minutos", "Media", "sushimaki", true),
        infoReceta( uriTacosAlPastor.toString(),"Tacos al Pastor", uriIngredientesTacosAlPastor, uriInstruccionesTacosAlPastor, "Cena", "45 minutos", "Media", "tacospastor", true),
        infoReceta( uriPaellaDeMariscosos.toString(),"Paella de Mariscosos", uriIngredientesPaellaDeMariscosos, uriInstruccionesPaellaDeMariscosos, "Cena", "45 minutos", "Media", "paellademarisco", true),
        infoReceta( uriRatatouilles.toString(),"Ratatouille", uriIngredientesRatatouilles, uriInstruccionesRatatouilles, "Cena", "45 minutos", "Media", "ratatouille", true),
        infoReceta( uriPadThai.toString(),"Pad Thai", uriIngredientesPadThai, uriInstruccionesPadThai, "Cena", "45 minutos", "Media", "padthai", true),
        infoReceta( uriBroscht.toString(),"Broscht", uriIngredientesBroscht, uriInstruccionesBroscht, "Cena", "45 minutos", "Media", "borscht", true),
        infoReceta( uriCerviche.toString(),"Cerviche", uriIngredientesCerviche, uriInstruccionesCerviche, "Cena", "45 minutos", "Media", "cerviche", true),
        infoReceta( uriFalafel.toString(),"Falafel", uriIngredientesFalafel, uriInstruccionesFalafel, "Cena", "45 minutos", "Media", "falafel", true),
        infoReceta( uriBaklava.toString(),"Baklava", uriIngredientesBaklava, uriInstruccionesBaklava, "Cena", "45 minutos", "Media", "baklava", true),
        infoReceta( uriButterChicken.toString(),"Butter Chicken", uriIngredientesButterChicken, uriInstruccionesButterChicken, "Cena", "45 minutos", "Media", "butterchicken", true),
        infoReceta( uriPoutine.toString(),"Poutine", uriIngredientesPoutine, uriInstruccionesPoutine, "Cena", "45 minutos", "Media", "poutine", true),
        infoReceta( uriDimSum.toString(),"Dim Sum", uriIngredientesDimSum, uriInstruccionesDimSum, "Cena", "45 minutos", "Media", "dimsum", true),
        infoReceta( uriFeijoada.toString(),"Feijoada", uriIngredientesFeijoada, uriInstruccionesFeijoada, "Cena", "45 minutos", "Media", "feijoada", true),
        infoReceta( uriKimchiJjigae.toString(),"Kimchi Jjigae", uriIngredientesKimchiJjigae, uriInstruccionesKimchiJjigae, "Cena", "45 minutos", "Media", "kimchijjigae", true),
        infoReceta( uriShepherdsPie.toString(),"Shepherds Pie", uriIngredientesShepherdsPie, uriInstruccionesShepherdsPie, "Cena", "45 minutos", "Media", "shepherd_s_pie", true),
        infoReceta( uriChurros.toString(),"Churros", uriIngredientesChurros, uriInstruccionesChurros, "Cena", "45 minutos", "Media", "churros", true),
        infoReceta( uriRamen.toString(),"Ramen", uriIngredientesRamen, uriInstruccionesRamen, "Cena", "45 minutos", "Media", "ramen", true),
        infoReceta( uriGnocchi.toString(),"Gnocchi", uriIngredientesGnocchi, uriInstruccionesGnocchi, "Cena", "45 minutos", "Media", "gnocchi", true),
        infoReceta( uriTabule.toString(),"Tabule", uriIngredientesTabule, uriInstruccionesTabule, "Cena", "45 minutos", "Media", "tabule", true),

    )
    inViewModel.initializedRecetaList(initialRecetaList)
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PantallaInicio(modifier: Modifier = Modifier, inViewModel: BasicViewModel) {

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

