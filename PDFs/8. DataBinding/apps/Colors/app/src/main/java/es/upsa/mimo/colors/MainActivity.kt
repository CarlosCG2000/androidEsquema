package es.upsa.mimo.colors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import es.upsa.mimo.colors.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    val viewModel: MainViewModel by viewModels()
    lateinit var dataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        dataBinding.viewModel = viewModel
        dataBinding.lifecycleOwner = this
    }
}