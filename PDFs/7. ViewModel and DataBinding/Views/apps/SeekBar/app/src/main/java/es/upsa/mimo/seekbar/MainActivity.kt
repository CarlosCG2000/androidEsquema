package es.upsa.mimo.seekbar

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
import es.upsa.mimo.seekbar.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity()
{
    val defaultArgs: Bundle = bundleOf().apply {
                                                   putInt(Colors.ALPHA.name, 0xFF)
                                                   putInt(Colors.RED.name,   0x77)
                                                   putInt(Colors.GREEN.name, 0x77)
                                                   putInt(Colors.BLUE.name,  0x77)
                                               }

    val viewModel: MainViewModel by viewModels() { MainViewModel.Factory(this, defaultArgs) }
    lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate( layoutInflater )
        setContentView(viewBinding.root)

        initializeSeekBarListener(viewBinding.sbAlpha) { progress -> viewModel.update(Colors.ALPHA, progress) }
        initializeSeekBarListener(viewBinding.sbRed)   { progress -> viewModel.update(Colors.RED, progress)   }
        initializeSeekBarListener(viewBinding.sbGreen) { progress -> viewModel.update(Colors.GREEN, progress) }
        initializeSeekBarListener(viewBinding.sbBlue)  { progress -> viewModel.update(Colors.BLUE, progress)  }

        initializeColor(viewModel.alphaValue, viewBinding.sbAlpha)
        initializeColor(viewModel.redValue,   viewBinding.sbRed)
        initializeColor(viewModel.greenValue, viewBinding.sbGreen)
        initializeColor(viewModel.blueValue,  viewBinding.sbBlue)

        showColorValue(viewModel.redValue,   viewBinding.tvRed)
        showColorValue(viewModel.greenValue, viewBinding.tvGreen)
        showColorValue(viewModel.blueValue,  viewBinding.tvBlue)
        showColorValue(viewModel.color,      viewBinding.tvColor, "#%08X")

        tintColor(viewModel.redColor,   viewBinding.tvRed)
        tintColor(viewModel.greenColor, viewBinding.tvGreen)
        tintColor(viewModel.blueColor,  viewBinding.tvBlue)
        tintColor(viewModel.color,      viewBinding.tvColor)
    }

    fun initializeSeekBarListener(seekBar: SeekBar, listener: (progress: Int)-> Unit)
    {
        seekBar.setOnSeekBarChangeListener( ColorSeekBarChangeListener(listener) )
    }

    fun initializeColor(color: Flow<Int>, seekBar: SeekBar)
    {
        lifecycleScope.launch() { seekBar.progress = color.first() }
    }

    fun showColorValue(colorValue: Flow<Int>, textView: TextView, format: String = "%02X")
    {
        lifecycleScope.launch() { colorValue.collect() { textView.text = String.format(format, it) } }
    }

    fun tintColor(color: Flow<Int>, textView: TextView)
    {
        lifecycleScope.launch() { color.collect() { textView.backgroundTintList = ColorStateList.valueOf(it) } }
    }
}

class ColorSeekBarChangeListener(val listener: (progress: Int)-> Unit ) : SeekBar.OnSeekBarChangeListener
{
    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean)
    {
        if (fromUser == true) listener.invoke(progress)
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {}

    override fun onStopTrackingTouch(seekBar: SeekBar?)  {}

}