package es.upsa.mimo.listadocontactos.data.sources.local

import es.upsa.mimo.listadocontactos.data.sources.ContactsDao
import es.upsa.mimo.listadocontactos.data.entities.ContactDB

class ContactsDaoLocal: ContactsDao {

    // Mock ficticia de datos para acceder a ella
    private val data: MutableMap<Long, ContactDB> = mutableMapOf(
        Pair(1L, ContactDB(1L, "Carlos", "carlos@gmail.com", "612-345-653", "Calle Compañia")),
        Pair(2L, ContactDB(2L, "María", "maria@gmail.com", "678-123-456", "Avenida Libertad")),
        Pair(3L, ContactDB(3L, "Juan", "juan@yahoo.com", "690-567-890", "Calle Mayor")),
        Pair(4L, ContactDB(4L, "Lucía", "lucia@hotmail.com", "645-234-789", "Plaza España")),
        Pair(5L, ContactDB(5L, "Pedro", "pedro@gmail.com", "600-789-123", "Calle Sol")),
        Pair(6L, ContactDB(6L, "Ana", "ana@gmail.com", "610-456-987", "Avenida Constitución")),
        Pair(7L, ContactDB(7L, "Pablo", "pablo@outlook.com", "622-345-678", "Calle del Río")),
        Pair(8L, ContactDB(8L, "Sofía", "sofia@gmail.com", "633-987-654", "Paseo Marítimo")),
        Pair(9L, ContactDB(9L, "David", "david@yahoo.com", "655-321-876", "Calle Luna")),
        Pair(10L, ContactDB(10L, "Elena", "elena@gmail.com", "677-654-321", "Calle del Sol")),
        Pair(11L, ContactDB(11L, "Javier", "javier@hotmail.com", "699-111-222", "Avenida del Parque")),
        Pair(12L, ContactDB(12L, "Laura", "laura@outlook.com", "622-999-888", "Calle del Olivo")),
        Pair(13L, ContactDB(13L, "Raúl", "raul@gmail.com", "688-222-333", "Calle Primavera")),
        Pair(14L, ContactDB(14L, "Teresa", "teresa@yahoo.com", "677-444-555", "Paseo de la Estación")),
        Pair(15L, ContactDB(15L, "Alberto", "alberto@gmail.com", "633-666-777", "Calle de la Paz")),
        Pair(16L, ContactDB(16L, "Cristina", "cristina@hotmail.com", "655-888-999", "Avenida de los Pinos"))
    )

    // Implementa las funciones de toda fuente de datos (ContactsDao)
    override fun findAll(): List<ContactDB> {
        return data.values.toList()
    }

    override fun findById(id: Long): ContactDB? {
        return data[id]
    }

}