package es.upsa.mimo.listadocontactos.presentation.screens.contactDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.Factory
import androidx.lifecycle.viewmodel.CreationExtras
import es.upsa.mimo.listadocontactos.domain.usecases.GetContactByIdUsecase
import es.upsa.mimo.listadocontactos.presentation.ListApplication
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ContactDetailViewModel(val getContactByIdUsecase: GetContactByIdUsecase): ViewModel() {

    // asincrono para manejarlo en segundo plano
    private val _state: MutableStateFlow<ContactDetailStateUI> = MutableStateFlow(ContactDetailStateUI())
    val state: StateFlow<ContactDetailStateUI> = _state.asStateFlow() // tambien asincrono pero inmutable

    fun findContactById(id:Long){
        val contact = getContactByIdUsecase.execute(id)

        _state.update {
            it.copy( contact = contact)
        }
    }

    companion object {
        fun factory(): Factory = object : Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                // Accedemos al objeto Aplication con la implementacion (unica que tenemos)
                // A través de extras s epuede acceder al Aplication (al igual que se podia al Bundle).
                val application = extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as ListApplication

                // Puedo acceder a través de 'application' al casos de uso que le pasamos por parámetro.
                return ContactDetailViewModel (application.getContactByIdUsecase) as T
            }
        }
    }

}