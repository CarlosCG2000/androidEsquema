package es.upsa.layouts.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension


@Composable
fun ConstraintLayoutScreen(){
    ConstraintLayout (modifier = Modifier.fillMaxSize()
                                        .background(Color.White)){

        val (btA, btB, btC, btD) = createRefs()

        Button(onClick = {},
                modifier = Modifier.constrainAs(btA) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom) // bottom en bottom del padre
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) { Text("A") }

        Button(onClick = {},
            modifier = Modifier.constrainAs(btB) {
                bottom.linkTo(btA.top) // bottom en bottom del padre
                end.linkTo(btA.start)
            }
        ) { Text("B") }

        Button(onClick = {},
            modifier = Modifier.constrainAs(btC) {
                start.linkTo(parent.start) // bottom en bottom del padre
                end.linkTo(parent.end)
                horizontalBias = 0.2f
            }
        ) { Text("C") }

        Button(onClick = {},
            modifier = Modifier.constrainAs(btD) {
                start.linkTo(parent.start) // bottom en bottom del padre
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints // equivalente a 0dp
            }
        ) { Text("D") }
    }
}

@Preview()
@Composable
fun ConstraintLayoutScreenPreview(){
    ConstraintLayoutScreen()
}