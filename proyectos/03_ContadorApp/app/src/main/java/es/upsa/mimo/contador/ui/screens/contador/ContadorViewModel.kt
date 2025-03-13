package es.upsa.mimo.contador.ui.screens.contador

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ContadorViewModel: ViewModel() {

    var contador = mutableStateOf(0)

    fun increment(){
        contador.value += 1
    }

    fun decrement(){
        contador.value -= 1
    }

}