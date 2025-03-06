package es.upsa.mimo.seekbar

import android.graphics.Color
import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import kotlinx.coroutines.flow.combine

class MainViewModel(val savedStateHandle: SavedStateHandle) : ViewModel()
{
    val alphaValue = savedStateHandle.getStateFlow(Colors.ALPHA.name, 0xFF)
    val redValue = savedStateHandle.getStateFlow(Colors.RED.name, 0x00)
    val greenValue = savedStateHandle.getStateFlow(Colors.GREEN.name, 0x00)
    val blueValue = savedStateHandle.getStateFlow(Colors.BLUE.name, 0x00)

    val redColor   = combine(alphaValue, redValue)   {alpha,red   -> Color.argb(alpha, red, 0, 0)}
    val greenColor = combine(alphaValue, greenValue) {alpha,green -> Color.argb(alpha, 0, green, 0)}
    val blueColor  = combine(alphaValue, blueValue)  {alpha,blue  -> Color.argb(alpha, 0, 0, blue)}

    val color = combine(alphaValue, redValue, greenValue, blueValue) {alpha, red, green, blue -> Color.argb(alpha, red, green, blue)}

    fun update(color: Colors, value: Int)
    {
        savedStateHandle[color.name] = value
    }


    class Factory(owner: SavedStateRegistryOwner, defaultArgs: Bundle?) : AbstractSavedStateViewModelFactory(owner, defaultArgs)
    {
        override fun <T : ViewModel> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T
        {
            return MainViewModel( handle ) as T
        }
    }
}