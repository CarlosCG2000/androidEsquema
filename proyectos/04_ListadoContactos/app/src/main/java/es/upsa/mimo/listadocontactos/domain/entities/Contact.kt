package es.upsa.mimo.listadocontactos.domain.entities

data class Contact (val id: Long,
                    val name: String,
                    val email: String,
                    val phone:String,
                    val address: String )