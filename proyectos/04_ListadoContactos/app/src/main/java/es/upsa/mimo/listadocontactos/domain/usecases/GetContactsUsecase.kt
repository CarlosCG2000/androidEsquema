package es.upsa.mimo.listadocontactos.domain.usecases

import es.upsa.mimo.listadocontactos.domain.entities.Contact

interface GetContactsUsecase {
    fun execute(): List<Contact>
}