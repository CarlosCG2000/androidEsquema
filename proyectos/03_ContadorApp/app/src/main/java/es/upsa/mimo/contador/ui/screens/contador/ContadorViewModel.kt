package es.upsa.mimo.contador.ui.screens.contador

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.Factory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ContadorViewModel(val savedStateHandle: SavedStateHandle, initialValue: Int): ViewModel() {

    // var contador = mutableStateOf(0) // Nunca un Holder Observable Sincrono ya que estan en el hilo principal

    //private val _contador: MutableStateFlow<Int> = MutableStateFlow(initialValue) // Asincrono esta en un hilo secundario
    // val contador: StateFlow<Int> = _contador.asStateFlow()

     val contador: StateFlow<Int> = savedStateHandle.getStateFlow(CONTADOR_KEY, initialValue) // recogemos el valor del Bundle, seguimos con un StateFlow (asincrono esta en un hilo secundario)

    fun increment(){
        // contador.value += 1
        // _contador.update { it + 1 }
        savedStateHandle[CONTADOR_KEY] = contador.value + 1
    }

    fun decrement(){
        // contador.value -= 1
        // _contador.update { it - 1 }
        savedStateHandle[CONTADOR_KEY] = contador.value - 1
    }

    fun updateContador(value:Int){
        savedStateHandle[CONTADOR_KEY] = value
    }

    companion object {
        const val CONTADOR_KEY = "es.upsa.mimo.contador.ui.screens.contador.ContadorViewModel.CONTADOR_KEY"

        // Queremos que nos devuelve el Factory, es decir un ViewModelProvider.Factory
        fun factory(initialValue: Int): Factory = object : Factory {

            // En la creación de la instanciación se ejecutara este metodo (con parametro extras)
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                return ContadorViewModel(initialValue = initialValue,
                                        savedStateHandle = extras.createSavedStateHandle()
                                        ) as T // como generico de tipo View Model
            }
        }

    }

}

