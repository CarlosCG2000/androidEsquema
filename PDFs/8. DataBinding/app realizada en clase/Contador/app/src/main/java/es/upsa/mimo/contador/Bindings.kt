package es.upsa.mimo.contador

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("qwerty")
fun TextView.setQwerty(value: String)
{
    this.text = value
}