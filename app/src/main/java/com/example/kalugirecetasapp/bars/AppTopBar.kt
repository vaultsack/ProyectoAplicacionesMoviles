package com.example.kalugirecetasapp.bars

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBarConDrawer(titulo: String, scope: CoroutineScope, drawerState: DrawerState) {
    TopAppBar(title = { Text(text = titulo) },
        navigationIcon = {
            IconButton(onClick = {
                //Abrir Drawer (Menu lateral App)
                scope.launch {
                    drawerState.apply {
                        if (isClosed) open() else close()
                    }
                }
            }) {
                Icon(imageVector = Icons.Default.Menu,
                    contentDescription ="Menu Icon",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}



@Composable
fun TopBarBuscar(state: MutableState<TextFieldValue>) {
    TextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value },
        modifier = Modifier
            .fillMaxWidth(),
        //.padding(8.dp),
        textStyle = TextStyle(color = Color.Blue,
            fontSize = 18.sp
        ),
        label = { Text(text = "Buscar") },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search,
                contentDescription ="Buscar",
                modifier = Modifier
                    .padding(15.dp)
                    .size(24.dp)
            )
        },
        trailingIcon = {
            if (state.value != TextFieldValue("")){
                IconButton(onClick = { state.value= TextFieldValue("") }){
                    Icon(imageVector = Icons.Default.Close,
                        contentDescription ="Cerrar",
                        modifier = Modifier
                            .padding(15.dp)
                            .size(24.dp)
                    )
                }
            }

        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.White,
            unfocusedIndicatorColor = Color.LightGray,
            disabledIndicatorColor = Color.Gray,
            cursorColor = Color.Blue,
        )
    )
}
