package es.upsa.mimo.listadocontactos.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import es.upsa.mimo.listadocontactos.presentation.screens.contactsList.ContactsScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {
            ContactsScreen()
        }
    }

}


