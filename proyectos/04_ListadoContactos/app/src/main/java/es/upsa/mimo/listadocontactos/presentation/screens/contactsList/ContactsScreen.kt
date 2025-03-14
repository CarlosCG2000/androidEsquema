package es.upsa.mimo.listadocontactos.presentation.screens.contactsList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.viewmodel.compose.viewModel
import es.upsa.mimo.listadocontactos.domain.entities.Contact


@Composable // Las funciones Composable se ponen en mayuúsculas
fun ContactsScreen() {

    val viewModel: ContactsViewModel = viewModel(factory = ContactsViewModel.factory())
    val state: State<ContactsStateUI> = viewModel.state.collectAsState() // sincrono para manejarlo en la UI

    //Queremos que siempre que se ejecute mi vista queremos que se ejecute el caso de uso de `queryContacts()` del View Model.
    LaunchedEffect(Unit /*Se ejecute el metodo cuando se modifique lo que tengamos aqui (variables), si tenemos 'Unit' se modificar solo una vez */) {
        viewModel.queryContacts()
    }

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

            items(items = state.value.contacts) { contact ->
                ItemContact(contact)
            }

        }
    }
}

@Composable
fun ItemContact(contact: Contact){
    Card(modifier = Modifier.fillMaxWidth()
                            .padding(10.dp),
        shape = RoundedCornerShape(20),
    ) {
        Column(modifier =   Modifier.fillMaxWidth()
                                    .padding(15.dp)
        ){
            Text(contact.name,
                style = MaterialTheme.typography.titleLarge)
            Text(contact.email)
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