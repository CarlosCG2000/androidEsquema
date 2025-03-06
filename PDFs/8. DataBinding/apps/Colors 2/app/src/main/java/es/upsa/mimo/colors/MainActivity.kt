package es.upsa.mimo.colors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import es.upsa.mimo.colors.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    val viewModel: MainViewModel by viewModels {  val defaultArgs = bundleOf(Colors.ALPHA.name to 0xFF,
                                                                                    Colors.RED.name to 0xFF,
                                                                                    Colors.GREEN.name to 0xFF,
                                                                                    Colors.BLUE.name to 0xFF
                                                                            )
                                                  MainViewModel.factory(this, defaultArgs)
                                               }
    lateinit var dataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        dataBinding.viewModel = viewModel
        dataBinding.lifecycleOwner = this
    }
}