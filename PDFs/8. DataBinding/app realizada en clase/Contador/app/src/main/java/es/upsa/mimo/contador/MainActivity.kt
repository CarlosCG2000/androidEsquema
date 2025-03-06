package es.upsa.mimo.contador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import es.upsa.mimo.contador.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity()
{
    companion object
    {
        val KEY_CONTADOR = "es.upsa.mimo.contador.key.CONTADOR"
    }

    val viewModel: MainViewModel by viewModels {
                                                   val defaultArgs: Bundle = bundleOf( Pair(MainActivity.KEY_CONTADOR, 77) )
                                                   MainViewModel.factory(this, defaultArgs)
                                               }
//    lateinit var viewBinding: ActivityMainBinding
    lateinit var dataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)



        dataBinding.viewModel = this.viewModel
        dataBinding.lifecycleOwner = this

//        dataBinding.btIncremento.setOnClickListener { viewModel.incrementar() }
//        dataBinding.btDecremento.setOnClickListener { viewModel.decrementar() }





//        viewBinding = ActivityMainBinding.inflate( this.layoutInflater  )
//        setContentView( viewBinding.root )
//
//        viewBinding.btIncremento.setOnClickListener { viewModel.incrementar() }
//        viewBinding.btDecremento.setOnClickListener { viewModel.decrementar() }
//
//        lifecycleScope.launch {
//
//            repeatOnLifecycle( Lifecycle.State.STARTED  )
//            {
//              viewModel.contador.collect { showContador( it ) }
//            }
//
//        }

    }

//    fun showContador(value : Int)
//    {
//        viewBinding.tvContador.text = getString(R.string.contador, value)
//    }



}