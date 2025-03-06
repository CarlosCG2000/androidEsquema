package es.upsa.mimo.colors

import android.graphics.Color
import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.savedstate.SavedStateRegistryOwner
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class MainViewModel(val savedStateHandle: SavedStateHandle) : ViewModel()
{
    val alpha = savedStateHandle.getStateFlow<Int>(Colors.ALPHA.name, 0xFF)
    val red = savedStateHandle.getStateFlow<Int>(Colors.RED.name, 0xFF)
    val green = savedStateHandle.getStateFlow<Int>(Colors.GREEN.name, 0xFF)
    val blue = savedStateHandle.getStateFlow<Int>(Colors.BLUE.name, 0xFF)

    val defaultColor = Color.argb(alpha.value, red.value, green.value, blue.value)


    val alphaRed: StateFlow<Int> = combine(alpha,red) {a,r -> Color.argb(a, r, 0x00, 0x00)}
                                                      .stateIn(viewModelScope, SharingStarted.Eagerly, Color.argb(0xFF, 0xFF, 0x00, 0x00))
    val alphaGreen: StateFlow<Int> = combine(alpha,green) {a,g -> Color.argb(a, 0x00, g, 0x00)}
                                                          .stateIn(viewModelScope, SharingStarted.Eagerly, Color.argb(0xFF, 0x00,0xFF,  0x00))
    val alphaBlue: StateFlow<Int> = combine(alpha,blue) {a,b -> Color.argb(a, 0x00, 0x00, b)}
                                                        .stateIn(viewModelScope, SharingStarted.Eagerly, Color.argb(0xFF, 0x00, 0x00, 0xFF))



    val color : StateFlow<Int> =  combine(alpha, red, green, blue) { a, r, g, b -> Color.argb(a, r, g, b) }
                                 .stateIn(viewModelScope, SharingStarted.Eagerly, defaultColor)


    fun updateColor(color: Colors, value: Int)
    {
        savedStateHandle.set(color.name, value)
    }

    companion object
    {
        fun factory(savedStateRegistryOwner: SavedStateRegistryOwner, defaultArgs: Bundle) = object : AbstractSavedStateViewModelFactory(savedStateRegistryOwner, defaultArgs)
                              {
                                  override fun <T : ViewModel> create(key: String, modelClass: Class<T>, savedStateHandle: SavedStateHandle): T
                                  {
                                      return MainViewModel(savedStateHandle) as T
                                  }
                              }
    }

}