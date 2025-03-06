package es.upsa.mimo.colors

import android.content.res.ColorStateList
import android.graphics.Color
import android.widget.SeekBar
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion

public interface OnChangeListener
{
    fun invoke(value: Int) : Unit
}

@BindingAdapter("onChangeListener")
fun SeekBar.setOnChangeListener(onChangeListener: OnChangeListener)
{
    this.setOnSeekBarChangeListener( object : SeekBar.OnSeekBarChangeListener
                                              {
                                                  override fun onProgressChanged(seekBar: SeekBar?, value: Int, fromUser: Boolean)
                                                  {
                                                      if (fromUser == true) onChangeListener.invoke(value)
                                                  }

                                                  override fun onStartTrackingTouch(p0: SeekBar?) {}

                                                  override fun onStopTrackingTouch(p0: SeekBar?) {}
                                              }
                                   )
}
