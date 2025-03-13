package es.upsa.mimo.contador.ui.screens.contador

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension


@Composable
fun ContadorScreen() { // Con Compose las funciones empiezan con letra mayúsculas.

    // var contador = 0
    // var contador = mutableStateOf(0)
    //var contador = remember { mutableStateOf(0) } // añadir '.value'
    // var contador by remember { mutableStateOf(0) }
    var contador by rememberSaveable { mutableStateOf(0) } // almacena valor en bundle

    ConstraintLayout(modifier = Modifier.fillMaxSize()
                                        .background(Color.White),
                     constraintSet = ContadorScreenContraintSet()
    ){
        Box(modifier = Modifier.layoutId("idBox")
                                .background(color = Color.Black, shape = CircleShape),
            contentAlignment = Alignment.Center

        ){ Text(text = "${contador}",
                color = Color.White) }

        Button(onClick = { contador += 1 },
               modifier = Modifier.layoutId("idIncrementButton")

            ) { Text(text = "+") }

        Button(onClick = { contador -= 1 },
            modifier = Modifier.layoutId("idDecrementButton")

        ) { Text(text = "-") }
    }
}

fun ContadorScreenContraintSet(): ConstraintSet {

    return ConstraintSet(){
        // Creando referencias (ids)
        val ( idBox, idIncrementButton, idDecrementButton )  = createRefsFor("idBox",
        "idIncrementButton", "idDecrementButton")

        // Creamos una cadena horizontal para los dos botones
        val idHorizontalChain = createHorizontalChain(idIncrementButton, idDecrementButton, chainStyle = ChainStyle.Spread)

        constrain(idBox) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            verticalBias = 0.05f
            start.linkTo(parent.start)
            end.linkTo(parent.end)

            // El tamaño de anchura de las letras será el 25 por ciento
            width = Dimension.percent(0.25f)
            // Misma proporción vertical que horizontal
            height = Dimension.ratio("h, 1:1")
        }

        constrain(idHorizontalChain) {
            // SOLO SE PUEDE DE FORMA HORIZONTAL
        }

        constrain(idIncrementButton) {
            top.linkTo(idBox.bottom, margin = 64.dp)
        }

        constrain(idDecrementButton) {
            baseline.linkTo(idIncrementButton.baseline)
        }

    }
}

@Preview
@Composable
fun ContadorScreenPreview() {
    ContadorScreen()
}