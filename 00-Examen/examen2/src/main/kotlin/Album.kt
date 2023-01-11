import java.io.File
import java.io.FileWriter
import java.io.IOException
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

    fun crearAlbum(){
        val nombreArchivo = "albumes.txt"
        val data = "..text to add.."

        try {
            FileWriter(nombreArchivo, true).use {
                it.write(data)
                println("Text appended to the file")
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun toString(): String {
        return "Album: $nombre, Duracion: $duracionTotal min, Total canciones: $numCanciones, Fecha: $fechaLanzamiento, " +
                "Debuta: $esDebut\n" +
                "Canciones:\n" +
                " $listaCanciones"
    }


}