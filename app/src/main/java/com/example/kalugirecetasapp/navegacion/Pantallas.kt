package com.example.kalugirecetasapp.navegacion

sealed class Pantallas(val route: String) {
    object PantallaInicio : Pantallas("inicio")
    object PantallaBusqueda : Pantallas("busqueda")
    object PantallaFavoritos : Pantallas("favoritos")
    object PantallaPerfil : Pantallas("perfil")
    object PantallaReceta : Pantallas("receta/{recetaId}")
    object PantallaConfiguracion : Pantallas("configuracion")
    object PantallaAnadir : Pantallas("anadir")
}