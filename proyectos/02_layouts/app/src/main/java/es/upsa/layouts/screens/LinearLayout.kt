package es.upsa.layouts.screens

import android.text.Layout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LayoutModifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.nio.file.WatchEvent

@Composable
fun LinearLayoutVertical(){
    Column( modifier = Modifier.fillMaxSize()
                    .background(Color.White),
        // horizontalAlignment = Alignment.End,
        // verticalArrangement = Arrangement.SpaceBetween // espacio sobrante otras: .spacedBy(50.dp), SpaceRound, SpaceEvenly

    ) {
        Button(
            onClick = {},
            modifier = Modifier.padding(start = 100.dp)
                .weight(0.5f)

        ) { Text("A") }

        Button(
            onClick = {}

        ) { Text("B") }

        Button(
            onClick = {},
            modifier = Modifier.align(Alignment.End)
                                        .weight(1f)
        ) { Text("C") }

        Button(
            onClick = {},
            modifier = Modifier.align(Alignment.CenterHorizontally)

        ) { Text("D") }
    }
}

@Composable
fun LinearLayoutHorizontal(modifier: Modifier =
                           Modifier.fillMaxSize(fraction = 1f)
                                    .background(Color.White)){
    Row (modifier = modifier) {
        Button(
            onClick = {}

        ) { Text("A") }

        Button(
            onClick = {},
            modifier = Modifier.fillMaxSize(0.25f) // El 25% de la altura de mi padre (Row)

        ) { Text("B") }

        Button(
            onClick = {}

        ) { Text("C") }

        Button(
            onClick = {}

        ) { Text("D") }
    }
}

@Preview(device = "spec:width=411dp,height=891dp", locale = "es")
@Composable
fun LinearLayoutVericalPreview(){
     LinearLayoutVertical()
     // LinearLayoutHorizontal()
}
