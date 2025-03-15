package es.upsa.mimo.listadocontactos.presentation.screens.contactDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ContactDetailScreen(id:Long) {

    val viewModel: ContactDetailViewModel = viewModel(factory = ContactDetailViewModel.factory())
    val state: State<ContactDetailStateUI> = viewModel.state.collectAsState() // sincrono para manejarlo en la UI

    LaunchedEffect (Unit){
        viewModel.findContactById(id)
    }

    Column(modifier = Modifier.fillMaxSize().padding(start = 150.dp, top = 400.dp)) {
            Text("Id: ${state.value.contact?.id}")
            Text("Name: ${state.value.contact?.name}")
            Text("Email: ${state.value.contact?.id}")
            Text("Phone: ${state.value.contact?.phone}")
            Text("Address: ${state.value.contact?.address}")
    }


}