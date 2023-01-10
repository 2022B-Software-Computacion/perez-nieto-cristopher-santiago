import java.util.*
import java.time.LocalDate

class Cancion(
    var id: Int,
    var fechaEstreno: LocalDate,
    var nombre: String,
    var duracion: Float,
    var esExplicita: Boolean
    )
{
    override fun toString(): String {
        return "id: $id,Fecha: $fechaEstreno,Cancion: $nombre,Duracion: $duracion min,Explicita: $esExplicita"
    }
}