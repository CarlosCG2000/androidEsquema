package es.upsa.mimo.colors

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.databinding.BindingConversion

object Converters
{
    @BindingConversion
    @JvmStatic fun asColor(value: Int): ColorStateList
    {
        return ColorStateList.valueOf(value)
    }


}