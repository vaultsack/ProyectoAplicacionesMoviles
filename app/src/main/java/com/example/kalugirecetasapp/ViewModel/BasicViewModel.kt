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
                esFavorito = true
            ),
            Receta(
                id = "2",
                nombre = "Sushi Maki",
                imagen = R.drawable.sushimaki,
                descripcion = "Un tipo de sushi proveniente de Japón",
                ingredientes = listOf(
                    "2 tazas de arroz para sushi",
                    "4 hojas de alga nori",
                    "200 g de pescado fresco (salmón o atún)",
                    "Pepino en tiras",
                    "Vinagre de arroz",
                    "Azúcar",
                    "Sal"
                ),
                pasos = listOf(
                    "Cocina el arroz",
                    "Mezcla con vinagre de arroz, azúcar y sal",
                    "Sobre una hoja de nori, extiende el arroz",
                    "Coloca el pescado y pepino, enrolla con una esterilla y corta en piezas."
                ),
                tiempoPreparacion = 30,
                porciones = 6,
                dificultad = "Alta",
                categoria = "Comidas",
                esFavorito = false
            ),
            Receta(
                id = "3",
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
            ),
            Receta(
                id = "4",
                nombre = "Tacos al pastor",
                imagen = R.drawable.tacospastor,
                descripcion = "Auténticos tacos al pastor de México",
                ingredientes = listOf(
                    "500g de cerdo marinado en achiote",
                    "Piña en trozos",
                    "8 tortillas de maíz",
                    "Cebolla picada",
                    "Cilantro"
                ),
                pasos = listOf(
                    "Cocina el cerdo marinado en una plancha hasta dorar",
                    "Calienta las tortillas y sirve el cerdo con piña, cebolla y cilantro."
                ),
                tiempoPreparacion = 30,
                porciones = 6,
                dificultad = "Alta",
                categoria = "Comidas",
                esFavorito = true
            ),
            Receta(
                id = "5",
                nombre = "Ratatouille",
                imagen = R.drawable.rattatouille,
                descripcion = "El auténtico y famoso plato.",
                ingredientes = listOf(
                    "1 berenjena",
                    "1 calabacín",
                    "1 pimiento rojo",
                    "2 tomates",
                    "Aceite de oliva",
                    "Hierbas provenzales",
                    "Sal",
                    "Pimienta"
                ),
                pasos = listOf(
                    "Corta las verduras en rodajas",
                    "Colócalas en una fuente de horno alternándolas",
                    "Rocía en aceite y hierbas. Hornea a 180ºC por 40 minutos",
                    "Dejar reposar"
                ),
                tiempoPreparacion = 50,
                porciones = 6,
                dificultad = "Alta",
                categoria = "Comidas",
                esFavorito = true
            ),
            Receta(
                id = "6",
                nombre = "Pad Thai",
                imagen = R.drawable.padthai,
                descripcion = "Un plato auténtico proveniente de Tailandia",
                ingredientes = listOf(
                    "200 g de fideos de arroz",
                    "150 g de camarones",
                    "2 huevos",
                    "Maní triturado",
                    "Brotes de soja",
                    "Salsa de tamarindo",
                    "Ajo",
                    "Aceite"
                ),
                pasos = listOf(
                    "Saltea ajo y camarones",
                    "Añade los fideos cocidos, huevo batido y salsa de tamarindo",
                    "Mezcla bien y sirve con maní y brotes"
                ),
                tiempoPreparacion = 25,
                porciones = 6,
                dificultad = "Alta",
                categoria = "Comidas",
                esFavorito = false
            ),
            Receta(
                id = "7",
                nombre = "Borscht",
                imagen = R.drawable.borscht,
                descripcion = "Un auténtico caldo de Rusia",
                ingredientes = listOf(
                    "3 remolachas",
                    "2 zanahorias",
                    "2 patatas",
                    "1 cebolla",
                    "Caldo de carne",
                    "Crema agría"
                ),
                pasos = listOf(
                    "Cocina las verduras en el caldo",
                    "Licua parte del caldo y mezcla con el resto",
                    "Sirve con crema agria"
                ),
                tiempoPreparacion = 40,
                porciones = 6,
                dificultad = "Alta",
                categoria = "Comidas",
                esFavorito = false
            ),
            Receta(
                id = "8",
                nombre = "Ceviche",
                imagen = R.drawable.ceviche,
                descripcion = "Un plato preparado desde Perú",
                ingredientes = listOf(
                    "300 g de pescado blanco fresco",
                    "Jugo de 4 limas",
                    "1 cebolla morada",
                    "Cilantro",
                    "Ají"
                ),
                pasos = listOf(
                    "Marina el pescado en jugo de lima",
                    "Añade cebolla, ají y cilantro picado",
                    "Sirve frío"
                ),
                tiempoPreparacion = 15,
                porciones = 6,
                dificultad = "Alta",
                categoria = "Comidas",
                esFavorito = false
            ),
            Receta(
                id = "9",
                nombre = "Falafel",
                imagen = R.drawable.falafel,
                descripcion = "Una comida del Medio Oriente",
                ingredientes = listOf(
                    "300 g de garbanzos",
                    "Ajo",
                    "Perejil",
                    "Comino",
                    "Harina",
                    "Aceite para freír"
                ),
                pasos = listOf(
                    "Tritura los garbanzos con ajo y perejil",
                    "Forma bolitas, pásalas por harina y fríelas",
                    "Sirve en pita con ensalada y tahini"
                ),
                tiempoPreparacion = 30,
                porciones = 6,
                dificultad = "Alta",
                categoria = "Comidas",
                esFavorito = false
            ),
            Receta(
                id = "10",
                nombre = "Baklava",
                imagen = R.drawable.baklava,
                descripcion = "Auténtico baklava de turquía",
                ingredientes = listOf(
                    "Masa filo",
                    "Nueces picadas",
                    "Mantequilla derretida",
                    "Almíbar (azúcar, agua y miel)"
                ),
                pasos = listOf(
                    "Alterna capas de masa filo con nueces y mantequilla",
                    "Hornea a 180ºC por 30 minutos",
                    "Baña con almíbar caliente"
                ),
                tiempoPreparacion = 50,
                porciones = 6,
                dificultad = "Alta",
                categoria = "Comidas",
                esFavorito = false
            ),
            Receta(
                id = "11",
                nombre = "Butter Chicken",
                imagen = R.drawable.butterchicken,
                descripcion = "Pollo con mantequilla de Turquía",
                ingredientes = listOf(
                    "500 g de pollo",
                    "1 taza de tomate triturado",
                    "1 taza de crema",
                    "2 cucharadas de mantequilla",
                    "Especias (garam masala, cúrcuma, jengibre)"
                ),
                pasos = listOf(
                    "Marina el pollo en yogur y especias por 1 hora",
                    "Cocina el pollo en mantequilla hasta dorar",
                    "Añade el tomate y cocina ahora a fuego lento",
                    "Agrega la crema y ajusta los condimentos"
                ),
                tiempoPreparacion = 45,
                porciones = 6,
                dificultad = "Alta",
                categoria = "Comidas",
                esFavorito = false
            ),
            Receta(
                id = "12",
                nombre = "Poutine",
                imagen = R.drawable.poutine,
                descripcion = "Plato venido desde el norte de América, Canadá",
                ingredientes = listOf(
                    "Papas fritas",
                    "Queso en grano",
                    "Salsa de carne (gravy)"
                ),
                pasos = listOf(
                    "Fríe las papas hasta dorar",
                    "Coloca las papas en un plato, añade queso y cubre con la salsa caliente"
                ),
                tiempoPreparacion = 30,
                porciones = 6,
                dificultad = "Alta",
                categoria = "Comidas",
                esFavorito = false
            ),
            Receta(
                id = "13",
                nombre = "Dim Sum",
                imagen = R.drawable.dimsum,
                descripcion = "Una racuón de Dim Sum de China",
                ingredientes = listOf(
                    "Masa para dumplings",
                    "Carne de cerdo picada",
                    "Camarones",
                    "Jengibre",
                    "Salsa de soya"
                ),
                pasos = listOf(
                    "Mezcla los ingredientes del relleno",
                    "Rellena la masa y cierra en forma de pequeños paquetes",
                    "Cocina al vapor durante 10 minutos"
                ),
                tiempoPreparacion = 40,
                porciones = 6,
                dificultad = "Alta",
                categoria = "Comidas",
                esFavorito = false
            ),
            Receta(
                id = "14",
                nombre = "Feijoada",
                imagen = R.drawable.feijoada,
                descripcion = "Un gran plato brasileño",
                ingredientes = listOf(
                    "500 g de frijoles brasileños",
                    "200 g de carne de cerdo",
                    "200 g de chorizo",
                    "Cebolla",
                    "Ajo",
                    "Laurel"
                ),
                pasos = listOf(
                    "Cocina los frijoles en agua hasta que estén tiernos",
                    "Sofríe cebolla y ajo, añade la carne y cocina hasta dorar",
                    "Incorpora los frijoles y cocina a fuego lento"
                ),
                tiempoPreparacion = 120,
                porciones = 6,
                dificultad = "Alta",
                categoria = "Comidas",
                esFavorito = false
            ),
            Receta(
                id = "15",
                nombre = "Kimchi Jjigae",
                imagen = R.drawable.kimchijjigae,
                descripcion = "Un plato de la auténtica Corea del sur",
                ingredientes = listOf(
                    "200 g de kimchi",
                    "Tofu",
                    "Cerdo",
                    "Caldo de verduras",
                    "Ajo",
                    "Aceite de sésamo"
                ),
                pasos = listOf(
                    "Cocina el cerdo con ajo y aceite de sésamo",
                    "Añade el kimchi y el caldo, hierve durante 15 minutos",
                    "Incorpora el tofu en trozos y cocina 5 minutos más"
                ),
                tiempoPreparacion = 30,
                porciones = 6,
                dificultad = "Alta",
                categoria = "Comidas",
                esFavorito = false
            ),
            Receta(
                id = "16",
                nombre = "Stepherd's Pie",
                imagen = R.drawable.shepherdspie,
                descripcion = "Un postre de Reino Unido",
                ingredientes = listOf(
                    "500 g de carne molida",
                    "500 g de puré de papas",
                    "Zanahorias",
                    "Guisantes",
                    "Caldo de carne"
                ),
                pasos = listOf(
                    "Cocina la carne molida con las verduras y el caldo",
                    "Coloca la mezcla en un molde, cubre con puré de papas",
                    "Hornea a 200°C durante 20 minutos"
                ),
                tiempoPreparacion = 60,
                porciones = 6,
                dificultad = "Alta",
                categoria = "Comidas",
                esFavorito = false
            ),
            Receta(
                id = "17",
                nombre = "Churros",
                imagen = R.drawable.churros,
                descripcion = "Los auténticos churros de España",
                ingredientes = listOf(
                    "1 taza de harina",
                    "1 taza de agua",
                    "1 cucharada de mantequilla",
                    "Azúcar",
                    "Canela",
                    "Aceite para freír"
                ),
                pasos = listOf(
                    "Hierve agua con mantequilla, añade harina y mezcla hasta formar una masa",
                    "Forma los churros con una manga pastelera y fríelos",
                    "Espolvorea con azúcar y canela"
                ),
                tiempoPreparacion = 30,
                porciones = 6,
                dificultad = "Alta",
                categoria = "Comidas",
                esFavorito = true
            ),
            Receta(
                id = "18",
                nombre = "Ramen",
                imagen = R.drawable.ramen,
                descripcion = "El característico plato de Japón",
                ingredientes = listOf(
                    "Fideos ramen",
                    "Caldo de pollo",
                    "Huevo cocido",
                    "Puerros",
                    "Algas",
                    "Cerdo asado"
                ),
                pasos = listOf(
                    "Cocina los fideos en agua",
                    "Calienta el caldo con puerros y cerdo",
                    "Sirve los fideos en el caldo, añade huevo y algas"
                ),
                tiempoPreparacion = 40,
                porciones = 6,
                dificultad = "Alta",
                categoria = "Comidas",
                esFavorito = false
            ),
            Receta(
                id = "19",
                nombre = "Gnocchi",
                imagen = R.drawable.gnocchi,
                descripcion = "Un plato de salsa de tomate Italiano",
                ingredientes = listOf(
                    "500 g de papas",
                    "150 g de harina",
                    "1 huevo",
                    "Sal",
                    "Salsa de tomate"
                ),
                pasos = listOf(
                    "Cocina y tritura las papas, mezcla con harina, huevo y sal",
                    "Forma pequeñas bolitas y cocina en agua hirviendo hasta que floten",
                    "Sirve con salsa de tomate"
                ),
                tiempoPreparacion = 50,
                porciones = 6,
                dificultad = "Alta",
                categoria = "Comidas",
                esFavorito = false
            ),
            Receta(
                id = "20",
                nombre = "Tabulé",
                imagen = R.drawable.tabule,
                descripcion = "Un cuscús libanés",
                ingredientes = listOf(
                    "200 g de cuscús",
                    "2 tomates",
                    "1 pepino",
                    "Perejil",
                    "Menta",
                    "Jugo de limón",
                    "Aceite de oliva"
                ),
                pasos = listOf(
                    "Cocina el cuscús según las instrucciones del paquete",
                    "Mezcla con vegetales picados, perejil, menta, limón y aceite",
                    "Sirve frío como ensalada"
                ),
                tiempoPreparacion = 20,
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
