package es.upsa.mimo.listadocontactos.domain.usecases

import es.upsa.mimo.listadocontactos.domain.entities.Contact

interface GetContactByIdUsecase {
    fun execute(id: Long): Contact?
}