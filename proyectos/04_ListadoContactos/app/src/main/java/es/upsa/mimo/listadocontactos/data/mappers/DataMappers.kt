package es.upsa.mimo.listadocontactos.data.mappers

import es.upsa.mimo.listadocontactos.data.entities.ContactDB
import es.upsa.mimo.listadocontactos.domain.entities.Contact


//fun ContactDB.asContact(): Contact { // Es una funcion de extension de ContactDB
//    // tiene el contexto de ContactDB
//
//    return Contact( id = this.id,
//                    name = this.name,
//                    email = this.email,
//                    phone = this.phoneNumber,
//                    address = this.address )
//}

// Es una funcion de extension de ContactDB
fun ContactDB.asContact(): Contact = Contact(id, name, email, phoneNumber, address )


