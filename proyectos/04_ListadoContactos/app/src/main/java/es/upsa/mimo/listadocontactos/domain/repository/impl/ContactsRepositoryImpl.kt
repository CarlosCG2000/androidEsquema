package es.upsa.mimo.listadocontactos.domain.repository.impl

import es.upsa.mimo.listadocontactos.data.entities.ContactDB
import es.upsa.mimo.listadocontactos.data.mappers.asContact
import es.upsa.mimo.listadocontactos.data.sources.ContactsDao
import es.upsa.mimo.listadocontactos.domain.entities.Contact
import es.upsa.mimo.listadocontactos.domain.repository.ContactsRepository

class ContactsRepositoryImpl(val dao: ContactsDao): ContactsRepository {

    override fun findAll(): List<Contact> {

        val listContactDB: List<ContactDB> = dao.findAll()

        val listContact = listContactDB.map { contactDb ->
            contactDb.asContact() // utilizamos la extexion de mapeo creada
        }

        return listContact
    }

    override fun findById(id: Long): Contact? {
        val contactDb = dao.findById(id)

        val contact = contactDb?.asContact()

        return contact
    }
}