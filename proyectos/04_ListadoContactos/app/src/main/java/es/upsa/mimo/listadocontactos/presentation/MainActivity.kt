package es.upsa.mimo.listadocontactos.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import es.upsa.mimo.listadocontactos.presentation.navegation.ApplicationNavegation
import es.upsa.mimo.listadocontactos.presentation.screens.contactsList.ContactsScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {
            // ContactsScreen()
            MainScreen()
        }
    }

}

// Composable que llama a la navegación
@Composable
fun MainScreen(){
    val navController = rememberNavController()
    ApplicationNavegation(navController) // ApplicationNavegation, es  mi navegación
}


