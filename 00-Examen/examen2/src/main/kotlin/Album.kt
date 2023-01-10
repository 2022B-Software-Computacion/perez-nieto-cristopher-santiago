import java.time.LocalDate

class Album {
    var numCanciones: Int = 0
    var fechaLanzamiento: LocalDate? = null
    var nombre: String = ""
    var duracionTotal: Float = 0f
    var esDebut: Boolean = true
    var listaCanciones = mutableListOf<Cancion>()

    constructor() {
    }

    constructor(numCanciones: Int, fechaLanzamiento: LocalDate, nombre: String, duracionTotal: Float, esDebut: Boolean
        , listaCanciones: MutableList<Cancion>)
    {
        this.numCanciones = numCanciones
        this.fechaLanzamiento = fechaLanzamiento
        this.nombre = nombre
        this.duracionTotal = duracionTotal
        this.esDebut = esDebut
        this.listaCanciones = listaCanciones
    }

    override fun toString(): String {
        return "Album num: $numCanciones, Fecha: $fechaLanzamiento, Album: $nombre, Duracion: $duracionTotal min, " +
                "Debuta: $esDebut" + "\nCanciones: $listaCanciones"
    }


}