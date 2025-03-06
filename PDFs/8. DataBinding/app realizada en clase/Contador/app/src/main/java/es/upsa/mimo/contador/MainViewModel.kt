package es.upsa.mimo.contador

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import kotlinx.coroutines.flow.StateFlow

class MainViewModel(private val savedStateHandle: SavedStateHandle): ViewModel()
{
//    private var contador: Int = savedStateHandle[MainActivity.KEY_CONTADOR] ?: 0

//    private val _contador: MutableStateFlow<Int> = MutableStateFlow(savedStateHandle[MainActivity.KEY_CONTADOR] ?: 0)
//    val contador: StateFlow<Int> = _contador.asStateFlow()

    val contador: StateFlow<Int> = savedStateHandle.getStateFlow(MainActivity.KEY_CONTADOR, 0)


    fun incrementar()
    {
        updateContador(1)
    }

    fun decrementar()
    {
        updateContador(-1)
    }

    private fun updateContador(value: Int)
    {
//        _contador.value = _contador.value + value
        savedStateHandle.set(MainActivity.KEY_CONTADOR, contador.value + value )
    }


    companion object
    {
        fun factory(owner: SavedStateRegistryOwner, defaultArgs: Bundle?): ViewModelProvider.Factory = object : AbstractSavedStateViewModelFactory(owner, defaultArgs)
                                                                                                       {
                                                                                                           override fun <T : ViewModel> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T
                                                                                                           {
                                                                                                               return MainViewModel(handle) as T
                                                                                                           }
                                                                                                       }
    }

}