package es.upsa.mimo.listadocontactos.presentation.navegation

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import es.upsa.mimo.listadocontactos.presentation.screens.contactDetail.ContactDetailScreen
import es.upsa.mimo.listadocontactos.presentation.screens.contactsList.ContactsScreen
import kotlinx.serialization.Serializable

// Definición de destinos a través de objetos o clases (con parámetros que representan propiedades)
@Serializable
object ContactScreenDestination // Destino de la vista listado de contactos

@Serializable
class ContactDetailScreenDestination(val id: Long) // Destino de la vista de una de contacto en detalle

@Composable
fun ApplicationNavegation(navController: NavHostController){

    // Necesitamos un 'NavHost' que va a describir el grafo de navegación
    // Para ello hay que especificar el NavController, que sera el objeto que a través del cual vamos a poder movernos, ir a través de una pantalla a otra.
    // 'NavHost' es como una máquina de estados nosotros vamos a describir distintos estados y le vamos a marcar en estado inicial. O lo que es lo mismo le estamos indicando distintos destinos y le indicamos  cual va a ser el destino inicial.
    // Tenemos que crear el grafo de navegación.
    // Cuando yo quiero ir un destino descrito a través de un objeto yo lo que tendré que hacer es invocar a la función que me lleve a la pantalla correspondiente.
    // Cuando me indique que el destino es otro objeto a su vez, yo tendré que acceder a la pantalla correspodiente a través de una lambda para acceder a dicha pantalla.

    NavHost(navController = navController, startDestination = ContactScreenDestination){

        // 1. Pantalla de listado de contactos
        composable<ContactScreenDestination>{ navBackStackEntry ->
            // Le tengo que pasar tantas lamdbas como destinos pueda tener
            ContactsScreen(){ id -> // Parámetro que necesita para ejecutar y poder realizar la navegacion
                val destino = ContactDetailScreenDestination(id = id)

                navController.navigate(destino) // Navegamos a la pantalla de detalles
            }

        }

        // 2. Pantalla de contacto en detalle
        composable<ContactDetailScreenDestination>{  navBackStackEntry /* destino */ ->
            val contactDetailScreenDestination: ContactDetailScreenDestination = navBackStackEntry.toRoute() // Obtenemos el objeto

            val id:Long = contactDetailScreenDestination.id

            ContactDetailScreen(id = id)
        }
    }
}