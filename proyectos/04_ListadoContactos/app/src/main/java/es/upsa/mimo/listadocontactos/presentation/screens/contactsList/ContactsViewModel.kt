package es.upsa.mimo.listadocontactos.presentation.screens.contactsList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.Factory
import androidx.lifecycle.viewmodel.CreationExtras
import es.upsa.mimo.listadocontactos.domain.usecases.GetContactsUsecase
import es.upsa.mimo.listadocontactos.presentation.ListApplication
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class ContactsViewModel(val getContactsUsecase: GetContactsUsecase): ViewModel() {
    private val _state: MutableStateFlow<ContactsStateUI> = MutableStateFlow(ContactsStateUI()) // asincrono para manejarlo en segundo plano

    val state: StateFlow<ContactsStateUI> = _state.asStateFlow() // tambien asincrono pero inmutable

    // Hay que llamar a los casos de uso
    fun queryContacts(){
        val contactsList = getContactsUsecase.execute() // recibimos la lista de los contactos

        // it es 'state.value' que es el valor actual de los contactos y lo actualizamos a 'contactsList'
        _state.update {
            it.copy( contacts = contactsList )
        }
    }

    companion object {
        fun factory(): Factory = object : Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                // Accedemos al objeto Aplication con la implementacion (unica que tenemos)
                // A través de extras se puede acceder al Aplication (al igual que se podia al Bundle).
                val application = extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as ListApplication

                // Puedo acceder a través de 'application' al casos de uso que le pasamos por parámetro.
                return ContactsViewModel (application.getContactsUsecase) as T
            }
        }
    }


}