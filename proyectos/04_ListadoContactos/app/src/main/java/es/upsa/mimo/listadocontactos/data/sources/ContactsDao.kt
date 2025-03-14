package es.upsa.mimo.listadocontactos.data.sources

import es.upsa.mimo.listadocontactos.data.entities.ContactDB

interface ContactsDao {
    fun findAll(): List<ContactDB>
    fun findById(id: Long): ContactDB?
}