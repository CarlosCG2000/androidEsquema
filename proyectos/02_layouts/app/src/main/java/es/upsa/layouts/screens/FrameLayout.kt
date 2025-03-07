package es.upsa.layouts.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FrameLayoutScreen01(){

    // Metodo Box: equivalente a un 'FrameLayout'
    Box( modifier = Modifier.fillMaxSize() // que ocupa lo máximo de anchura y altura
                            .background(Color.White) // color de fondo blanco
    )
    { // expresión lambda
        Button(
            onClick = {  }, // otra expresión lambda
            modifier = Modifier.align(Alignment.BottomEnd)
        )
        { Text(text = "A",
              modifier = Modifier// .fillMaxWidth()
        ) }

        Button(
            onClick = { },
            modifier = Modifier.align(Alignment.Center)
        )
        { Text(text = "B",
               modifier = Modifier.padding(30.dp)) }

        Button(
            onClick = { },
            modifier = Modifier.align(Alignment.TopStart)
        )
        { Text(text = "C") }
    }
}

@Composable
fun FrameLayoutScreen02() {
    Box(modifier = Modifier.size(200.dp, 300.dp)
                            .background(Color.White, shape = RoundedCornerShape(20.dp)),
        contentAlignment = Alignment.Center // por defecto salga centrado
    ){
        Text("A")
    }
}

// Elementos con las caracteristicas que tiene que tener mi visualizador grafico. Desde la rueda se puede configurar.
@Preview (device = "spec:width=411dp,height=891dp", locale = "es")
@Composable
fun FrameLayoutScreenPreview(){
    // FrameLayoutScreen01()
    FrameLayoutScreen02()
}
