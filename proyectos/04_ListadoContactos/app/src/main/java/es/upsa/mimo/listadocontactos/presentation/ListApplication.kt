package es.upsa.mimo.listadocontactos.presentation

import android.app.Application
import es.upsa.mimo.listadocontactos.data.sources.ContactsDao
import es.upsa.mimo.listadocontactos.data.sources.local.ContactsDaoLocal
import es.upsa.mimo.listadocontactos.domain.repository.ContactsRepository
import es.upsa.mimo.listadocontactos.domain.repository.impl.ContactsRepositoryImpl
import es.upsa.mimo.listadocontactos.domain.usecases.GetContactByIdUsecase
import es.upsa.mimo.listadocontactos.domain.usecases.GetContactsUsecase
import es.upsa.mimo.listadocontactos.domain.usecases.impl.GetContactByIdUsecaseImpl
import es.upsa.mimo.listadocontactos.domain.usecases.impl.GetContactsUsecaseImpl

class ListApplication: Application() {

    // La implementacion en produccion de Impl.
    private val contactDao: ContactsDao = ContactsDaoLocal()
    private val contactsRepository: ContactsRepository = ContactsRepositoryImpl(contactDao)
    val getContactsUsecase: GetContactsUsecase = GetContactsUsecaseImpl(contactsRepository)
    val getContactByIdUsecase: GetContactByIdUsecase = GetContactByIdUsecaseImpl(contactsRepository)

    override fun onCreate(){
        super.onCreate()
    }

}