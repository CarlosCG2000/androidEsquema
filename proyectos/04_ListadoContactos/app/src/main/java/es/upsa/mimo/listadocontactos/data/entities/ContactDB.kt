package es.upsa.mimo.listadocontactos.data.entities

data class ContactDB(val id: Long,
                     val name: String,
                     val email: String,
                     val phoneNumber:String, // diferente al Contact (donde se llama 'phone')
                     val address: String)