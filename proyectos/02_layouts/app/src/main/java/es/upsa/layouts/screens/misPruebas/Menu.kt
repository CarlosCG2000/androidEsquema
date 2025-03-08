package es.upsa.layouts.screens.misPruebas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import es.upsa.layouts.R

@Composable
fun MenuScreen(/*navController: NavController*/) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // 🔹 IMÁGENES EN LA PARTE SUPERIOR
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background), // Reemplaza con tu imagen
                contentDescription = "Imagen 1",
                modifier = Modifier.size(80.dp)
            )
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground), // Reemplaza con tu imagen
                contentDescription = "Imagen 2",
                modifier = Modifier.size(80.dp)
            )
        }

        // 🔹 LISTA DE OPCIONES DE MENÚ
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
//            items(menuItems) { item ->
//                // MenuItem(text = item.title, onClick = { navController.navigate(item.route) })
//            }
        }
    }
}

// 🔹 OPCIÓN INDIVIDUAL DEL MENÚ
@Composable
fun MenuItem(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(text, fontSize = 18.sp)
    }
}

// 🔹 MODELO DE DATOS PARA MENÚ
data class MenuOption(val title: String, val route: String)

// 🔹 LISTA DE OPCIONES DE MENÚ
val menuItems = listOf(
    MenuOption("Inicio", "home"),
    MenuOption("Perfil", "profile"),
    MenuOption("Configuración", "settings"),
    MenuOption("Acerca de", "about")
)

// 🔹 CONFIGURACIÓN DE NAVEGACIÓN
//@Composable
//fun AppNavigator() {
//    val navController = rememberNavController()
//
//    NavHost(navController, startDestination = "menu") {
//        composable("menu") { MenuScreen(navController) }
//        composable("home") { ScreenContent("Inicio") }
//        composable("profile") { ScreenContent("Perfil") }
//        composable("settings") { ScreenContent("Configuración") }
//        composable("about") { ScreenContent("Acerca de") }
//    }
//}

// 🔹 PANTALLA GENÉRICA PARA NAVEGACIÓN
@Composable
fun ScreenContent(title: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(title, fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
}

@Preview
@Composable
fun MenuScreenPreview(){
    MenuScreen()
}