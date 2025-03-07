package es.upsa.layouts.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun colorBt(): ButtonColors {
    return ButtonDefaults.buttonColors(containerColor = Color.Gray)  // Establece el color de fondo del botón
}

@Composable
fun curvaturaBt():  RoundedCornerShape {
    return RoundedCornerShape(10.dp) // Bordes redondeados
}

@Composable
fun layoutEjercicio1(){
    Box(modifier = Modifier.fillMaxSize()
                            .background(Color.White)
    ) {
        Button(
            onClick = {}, modifier = Modifier.fillMaxWidth().padding(50.dp),
            colors = colorBt(), shape = curvaturaBt()
        ) {
            Text(
                text = "SUPERIOR",
                color = Color.Black
            )

        }

        Box(
            modifier = Modifier.align(Alignment.BottomCenter)
                .size(width = 600.dp, height = 200.dp)
                .padding(horizontal = 50.dp)
                .padding(bottom = 40.dp)
        ) {
            Button(
                onClick = {},
                modifier = Modifier.size(width = 200.dp, height = 50.dp)
                    .align(Alignment.TopStart)
                ,
                colors = colorBt(), shape = curvaturaBt()
            ) {
                Text(
                    text = "A",
                    color = Color.Black
                )
            }

            Button(
                onClick = {},
                modifier = Modifier.size(width = 200.dp, height = 50.dp)
                    .align(Alignment.TopEnd),
                colors = colorBt(), shape = curvaturaBt()
            ) {
                Text(
                    text = "B",
                    color = Color.Black
                )
            }

            Button(
                onClick = {},
                modifier = Modifier.size(width = 200.dp, height = 50.dp)
                    .align(Alignment.BottomStart),
                colors = colorBt(), shape = curvaturaBt()
            ) {
                Text(
                    text = "C",
                    color = Color.Black
                )
            }

            Button(
                onClick = {},
                modifier = Modifier.size(width = 200.dp, height = 50.dp)
                    .align(Alignment.BottomEnd),
                colors = colorBt(), shape = curvaturaBt()
            ) {
                Text(
                    text = "D",
                    color = Color.Black
                )
            }
        }
    }

}

@Preview(device = "spec:width=611dp,height=891dp")
@Composable
fun layoutEjercicio1Preview(){
    layoutEjercicio1()
}