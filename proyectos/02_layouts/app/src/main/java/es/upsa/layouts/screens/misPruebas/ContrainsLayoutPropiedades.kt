package es.upsa.layouts.screens.misPruebas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import es.upsa.layouts.R

@Composable
fun AlignEdges(){
    ConstraintLayout( modifier = Modifier.fillMaxSize().background(Color.White) /*.size(width )*/) { // expresion lambda
        val (btA, btB, btC, btD, btE) = createRefs()

        // ____________ Posiciones comunes ____________
        Button(onClick = {},
                modifier = Modifier//.size(width = 200.dp, height = 60.dp) // 'wrap_content' por defecto
                            //.fillMaxSize()
                            .fillMaxWidth(0.5f)     // el 50% del ancho de la pantalla
                            .fillMaxHeight(0.05f)   // el 10% del largo de la pantalla
                            .constrainAs(btA){
                                top.linkTo(parent.top)
                                // height = Dimension.wrapContent
                                // width = Dimension.wrapContent
                            }
        ) { Text("A") }

        Button(onClick = {},
                modifier = Modifier.padding(10.dp)
                                    .constrainAs(btB){
                        top.linkTo(btA.bottom)
                        start.linkTo(btA.end)
                }
        ) { Text("B") }

        Button(onClick = {},
               modifier = Modifier.constrainAs(btC){
                            baseline.linkTo(btB.baseline)
                            start.linkTo(btB.end)
               }
        ) { Text("C") }
        // ________________________________________________

        Button(
            onClick = {},
            modifier = Modifier.constrainAs(btD) {
                top.linkTo(btC.bottom)
                // Me lo centra horizontalmente respecto el botón A
                // centerTo(btA) // me lo centra por completo tanto horizontalmente como verticalmente
                start.linkTo(btA.start)
                end.linkTo(btA.end)
            }
        ) { Text("Centrado D") }

        Button(
            onClick = {},
            modifier = Modifier.constrainAs(btE) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    // Ocupe lo máximo posible (como si fuese 0dp), por defecto sino es 'wrap_content'
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent // .value(90.dp)
                    // Sesgo cuando tiene al menos una horientación centrada
                    horizontalBias = 0.8f // un 80 por ciento, no afecta porque no esta centtrado horizontalmente
                    verticalBias = 0.25f // un 25 por ciento
            }
        ) { Text("E") }

        cadenaHorizontal(chainStyle = ChainStyle.SpreadInside)
        cadenaVertical(ChainStyle.Packed)

        posicionCircular()
        dimensionRatio()

        guias()
    }
}

@Composable
fun cadenaHorizontal(chainStyle:ChainStyle = ChainStyle.Spread) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (bt1, bt2, bt3) = createRefs()

        // Crear cadena de forma automatica, declarando eslabones y estilo
        val horizontalChain = createHorizontalChain(bt1, bt2, bt3, chainStyle = chainStyle)

        // Añadir caracteristicas de la cadena (horizontalmente)
        constrain(horizontalChain) {
            start.linkTo(parent.start/*, 50.dp (es el pading)*/)
            end.linkTo(parent.end /*, 50.dp*/)
        }

        Button(
            onClick = {},
            modifier = Modifier.constrainAs(bt1) {  // Es el eslabon principal
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom, 100.dp) // margen de 100.dp respecto el bottom
            }
        ) { Text("1")}

        Button(
            onClick = {},
            modifier = Modifier.constrainAs(bt2) {
                baseline.linkTo(bt1.baseline)
            }
        ) { Text("2")}

        Button(
            onClick = {},
            modifier = Modifier.constrainAs(bt3) {
                // baseline.linkTo(bt2.baseline)
                top.linkTo(bt2.bottom)
            }
        ) { Text("3")}

    }
}

@Composable
fun cadenaVertical(chainStyle:ChainStyle = ChainStyle.Spread) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (bt1, bt2, bt3) = createRefs()

        // Crear cadena de forma automatica, declarando eslabones y estilo
        val verticalChain = createVerticalChain(bt1, bt2, bt3, chainStyle = chainStyle)

        // Añadir caracteristicas de la cadena (vertical)
        constrain(verticalChain) {
            top.linkTo(parent.top, 300.dp)
            bottom.linkTo(parent.bottom)
        }

        Button(
            onClick = {},
            modifier = Modifier.constrainAs(bt1) {  // Es el eslabon principal
                start.linkTo(parent.start, 20.dp)
            }
        ) { Text("1")}

        Button(
            onClick = {},
            modifier = Modifier.constrainAs(bt2) {
               start.linkTo(bt1.end)
            }
        ) { Text("2")}

        Button(
            onClick = {},
            modifier = Modifier.constrainAs(bt3) {
                start.linkTo(bt2.start)
            }
        ) { Text("3")}

    }
}

@Composable
fun posicionCircular(){

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (btF, btG) = createRefs()

        Button( onClick = {},
            modifier = Modifier.constrainAs(btF) {
                bottom.linkTo(parent.bottom, 80.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) { Text("F") }

        Button(
            onClick = {},
            modifier = Modifier.constrainAs(btG) {
                circular(btF, 45f, 100.dp) // respecto que elemento, angulo, distancia (radio)
            }
        ) { Text("G") }
    }

}

@Composable
fun dimensionRatio(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val btRatio = createRef()

        Button(onClick = {},
            modifier = Modifier.constrainAs(btRatio) {
                bottom.linkTo(parent.bottom, 20.dp)
                height = Dimension.value(70.dp)
                width = Dimension.ratio("w, 16:9") // Mediante dimension de ratio

            }) { Text("Ratio 16:9") }
    }
}

@Composable
fun guias(){
    ConstraintLayout(modifier = Modifier.fillMaxSize())
    {
        val verticalGuide20dpFromStart = createGuidelineFromStart(20.dp)
        val verticalGuide40percentFromStart = createGuidelineFromStart(0.4f)
        val verticalGuide20dpFromEnd = createGuidelineFromEnd(20.dp)
        val verticalGuide20percentFromEnd = createGuidelineFromEnd(0.2f)
        val horizontalGuide40dpFromTop = createGuidelineFromTop(40.dp)
        val horizontalGuide40percentFromTop = createGuidelineFromTop(0.3f)
        val horizontalGuide40dpFromBottom = createGuidelineFromBottom(40.dp)
        val horizontalGuide50percentFromBottom = createGuidelineFromBottom(0.6f)
        val bt = createRef()

        Button(onClick = {}, modifier = Modifier.constrainAs(bt)
        {
            start.linkTo(verticalGuide20dpFromStart)
            end.linkTo(verticalGuide20percentFromEnd)
            top.linkTo(horizontalGuide40percentFromTop)
            bottom.linkTo(horizontalGuide50percentFromBottom)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        })
        { Text("Botón con guías") }
    }
}

@Composable
fun personalizacionBt() {

    ConstraintLayout(modifier = Modifier
                    .fillMaxSize() // .size(200.dp)
                    .border(2.dp, Color.Black, shape = RoundedCornerShape(10.dp)) // Borde negro
                    .clip(RoundedCornerShape(10.dp)) // Esquinas redondeadas
                    .background(Color.Yellow) // Fondo amarillo
                    .shadow(8.dp, shape = RoundedCornerShape(10.dp)) // Sombra de 10dp
                    .alpha(0.5f) // 50% de opacidad
    ) {
        val (bt, text, imagen) = createRefs()

        Button(
            onClick = {},
            modifier = Modifier.constrainAs(bt) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red, // Fondo rojo
                contentColor = Color.White // Texto blanco
            )
        ) { Text("Botón Rojo") }

        Text(
            text = "Hola Compose",
            fontSize = 20.sp,
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier
                // .size(width = 200.dp, height = 50.dp)
                .padding(16.dp) // Margen interno de 16dp
                .constrainAs(text) {
                    centerTo(parent)
                }
        )

        Image(
            modifier = Modifier
                .constrainAs(imagen) {
                    bottom.linkTo(parent.bottom, 30.dp)
                    centerHorizontallyTo(parent)
                },
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Fondo",
            contentScale = ContentScale.Crop // Ajusta la imagen
        )

    }
}

@Preview()
@Composable
fun AlignEdgesPreview(){
     AlignEdges()
    // cadenaHorizontal()
    // cadenaVertical()
    // posicionCircular()
    // dimensionRatio()
    // guias()
    // personalizacionBt()
}