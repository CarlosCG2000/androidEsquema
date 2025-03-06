package es.upsa.mimo.colors

import android.graphics.Color
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class MainViewModel() : ViewModel()
{
    val alpha: MutableStateFlow<Int> = MutableStateFlow(0xFF)
    val red: MutableStateFlow<Int> = MutableStateFlow(125)
    val green: MutableStateFlow<Int> = MutableStateFlow(125)
    val blue: MutableStateFlow<Int> = MutableStateFlow(125)

    val alphaRed: StateFlow<Int> = combine(alpha,red) {a,r -> Color.argb(a, r, 0x00, 0x00)}
                                          .stateIn(viewModelScope, SharingStarted.Eagerly, Color.argb(0xFF, 0xFF, 0x00, 0x00))
    val alphaGreen: StateFlow<Int> = combine(alpha,green) {a,g -> Color.argb(a, 0x00, g, 0x00)}
                                            .stateIn(viewModelScope, SharingStarted.Eagerly, Color.argb(0xFF, 0x00,0xFF,  0x00))
    val alphaBlue: StateFlow<Int> = combine(alpha,blue) {a,b -> Color.argb(a, 0x00, 0x00, b)}
                                           .stateIn(viewModelScope, SharingStarted.Eagerly, Color.argb(0xFF, 0x00, 0x00, 0xFF))


    val color : StateFlow<Int> =  combine(red, green, blue) { r, g, b -> Color.argb(0xFF, r, g, b) }
                                         .stateIn(viewModelScope, SharingStarted.Eagerly, Color.argb(0xFF,125, 125, 125))
}