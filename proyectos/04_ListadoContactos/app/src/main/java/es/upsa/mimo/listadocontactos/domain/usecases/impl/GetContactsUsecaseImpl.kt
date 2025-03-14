package es.upsa.mimo.listadocontactos.domain.usecases.impl

import es.upsa.mimo.listadocontactos.domain.entities.Contact
import es.upsa.mimo.listadocontactos.domain.repository.ContactsRepository
import es.upsa.mimo.listadocontactos.domain.usecases.GetContactsUsecase

class GetContactsUsecaseImpl(val contactsRepository: ContactsRepository): GetContactsUsecase {
    override fun execute(): List<Contact> {
        return contactsRepository.findAll()
    }
}