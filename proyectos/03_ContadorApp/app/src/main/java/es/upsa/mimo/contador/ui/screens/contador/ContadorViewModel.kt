package es.upsa.mimo.contador.ui.screens.contador

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ContadorViewModel(val savedStateHandle: SavedStateHandle): ViewModel() {

    // var contador = mutableStateOf(0) // Nunca un Holder Observable Sincrono ya que estan en el hilo principal

    //private val _contador: MutableStateFlow<Int> = MutableStateFlow(0) // Asincrono esta en un hilo secundario
    // val contador: StateFlow<Int> = _contador.asStateFlow()

     val contador: StateFlow<Int> = savedStateHandle.getStateFlow(CONTADOR_KEY, 0) // recogemos el valor del Bundle, seguimos con un StateFlow (asincrono esta en un hilo secundario)

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

    companion object{
        const val CONTADOR_KEY = "es.upsa.mimo.contador.ui.screens.contador.ContadorViewModel.CONTADOR_KEY"
    }

}

