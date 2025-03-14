package es.upsa.mimo.listadocontactos.domain.usecases.impl

import es.upsa.mimo.listadocontactos.domain.entities.Contact
import es.upsa.mimo.listadocontactos.domain.repository.ContactsRepository
import es.upsa.mimo.listadocontactos.domain.usecases.GetContactByIdUsecase

class GetContactByIdUsecaseImpl(val contactsRepository: ContactsRepository): GetContactByIdUsecase {

    override fun execute(id: Long): Contact? {
        return contactsRepository.findById(id)
    }
}