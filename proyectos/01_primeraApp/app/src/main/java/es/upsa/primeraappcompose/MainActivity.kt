package es.upsa.primeraappcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

// MI ACTIVIDAD
class MainActivity : ComponentActivity() // Esta clase es una Actividad,ya que extiende de 'ComponentActivity()'.
{

//  ETIQUETA DEL NOMBRE DE LA CLASE PARA EL LOG
    companion object { // Para declarar variables estaticas
        val TAG: String = MainActivity.javaClass.name // MainActivity::class.java.name
    }

//  EN EL CICLO DE VISTA (9 MÉTODOS POSIBLES)

//  Creación de la aplicación con parámetro que recibe para restaurar el estado en caso de cerrarse automáticamente la app.
//  Bundle? por que es ?: porque si se cierra manualmente es nula esa variable por lo que tiene que ser el tipo opcional.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//      Si utilizasemos 'Compose' en vez de 'View'
        setContent { // Especificamos que es lo que se tiene que mostrar
            Greeting( name = "Android", modifier = Modifier ) // Notación nominal de los parámetros en vez de posicional.
        //  Greeting( "Android", Modifier ) // Notación posicional de los parámetros en vez de nominal.
        }
//      Si utilizasemos 'View' en vez de 'Compose'
//      setContentView(R.layout.activity_main)

    }

//  OTROS MÉTODOS DEL CICLO DE VIDA
//    override fun onStart() {
//        super.onStart()
//        Log.i(TAG, "Pasando por el onStart()")
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        Log.i(TAG, "Pasando por el onRestoreInstanceState()")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Log.i(TAG, "Pasando por el onResume()")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.i(TAG, "Pasando por el onPause()")
//    }
//
//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        Log.i(TAG, "Pasando por el onSaveInstanceState()")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.i(TAG, "Pasando por el onStop()")
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//        Log.i(TAG, "Pasando por el onRestart()")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.i(TAG, "Pasando por el onDestroy()")
//    }
}



// ESTA FUERA DE LA ACTIVIDAD, SON FUNCIONES EXTERNAS

// Una función que defina una interface de usuario tiene que ser '@Composable'
@Composable // Quiere decir que va a definir una interface de usuario
fun Greeting(name: String, modifier: Modifier = Modifier) { // Con parámetros por defecto
    Text(
        text = "Hello ${name.uppercase()}!", // Lo que se muestra por pantalla
        modifier = modifier
    )
}

// La Preview para ver la interface antes de ejecutar
@Preview(showBackground = true) // Ver la Preview
@Composable
fun GreetingPreview() {
        Greeting("Android")
}
