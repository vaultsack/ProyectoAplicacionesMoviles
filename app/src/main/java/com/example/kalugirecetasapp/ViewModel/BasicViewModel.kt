package com.example.kalugirecetasapp.ViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.kalugirecetasapp.R
import com.example.kalugirecetasapp.model.Categoria
import com.example.kalugirecetasapp.model.Receta

class BasicViewModel : ViewModel() {
    val categorias = listOf(
        Categoria("1", "Desayunos", R.drawable.baseline_cookie_24),
        Categoria("2", "Comidas", R.drawable.baseline_library_books_24),
        Categoria("3", "Cenas", R.drawable.baseline_home_24),
        Categoria("4", "Postres", R.drawable.baseline_favorite_24),
        Categoria("5", "Bebidas", R.drawable.baseline_settings_24),
        Categoria("6", "Snacks", R.drawable.baseline_search_24)
    )

    private val _listaRecetas = mutableStateOf<List<Receta>>(
        listOf(
            Receta(
                id = "1",
                nombre = "Spaghetti Carbonara",
                imagen = R.drawable.spaghetticarbonara,
                descripcion = "Deliciosa pasta carbonara tradicional",
                ingredientes = listOf(
                    "400g espaguetis",
                    "200g panceta",
                    "4 yemas de huevo",
                    "100g queso parmesano",
                    "Pimienta negra"
                ),
                pasos = listOf(
                    "Cocinar la pasta al dente",
                    "Dorar la panceta",
                    "Mezclar yemas con queso",
                    "Combinar todo y servir"
                ),
                tiempoPreparacion = 30,
                porciones = 4,
                dificultad = "Media",
                categoria = "Comidas",
                esFavorito = false
            ),
            Receta(
                id = "2",
                nombre = "Paella de Marisco",
                imagen = R.drawable.paellademarisco,
                descripcion = "Auténtica paella española de mariscos",
                ingredientes = listOf(
                    "Arroz bomba",
                    "Mariscos variados",
                    "Azafrán",
                    "Caldo de pescado"
                ),
                pasos = listOf(
                    "Preparar el sofrito",
                    "Añadir arroz y caldo",
                    "Incorporar mariscos",
                    "Dejar reposar"
                ),
                tiempoPreparacion = 45,
                porciones = 6,
                dificultad = "Alta",
                categoria = "Comidas",
                esFavorito = false
            )
            // Puedes agregar más recetas siguiendo el mismo patrón
        )
    )
    val listaRecetas = _listaRecetas

    fun obtenerRecetaPorId(id: String): Receta? {
        return _listaRecetas.value.find { it.id == id }
    }
}
