package es.upsa.mimo.listadocontactos.domain.repository

import es.upsa.mimo.listadocontactos.domain.entities.Contact

interface ContactsRepository {
    fun findAll(): List<Contact> // listado de contactos
    fun findById(id: Long): Contact? // contacto en especifico, através del  id
}