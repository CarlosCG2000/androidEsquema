package es.upsa.mimo.listadocontactos.presentation.screens.contact

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.viewmodel.compose.viewModel
import es.upsa.mimo.listadocontactos.domain.entities.Contact


@Composable // Las funciones Composable se ponen en mayuúsculas
fun ContactsScreen() {

    val viewModel: ContactsViewModel = viewModel()

    val contacts: List <Contact> = emptyList()

    ConstraintLayout(
            modifier = Modifier.fillMaxSize(),
            constraintSet = contactsScreenConstraintSet()) {

        // LazyRow() {}
        LazyColumn(modifier = Modifier.layoutId("lazyColumn")) {
//            for (i in 1..10){
//                item {
//                    Text("Item $i")
//                }
//            }

            items(items = contacts) { contact ->

            }

        }
    }
}

fun contactsScreenConstraintSet(): ConstraintSet{

    return ConstraintSet(){

        val (lazyColumn) = createRefsFor("lazyColumn")

        constrain(lazyColumn) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)

            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContactsScreenPreview() {
    ContactsScreen()
}