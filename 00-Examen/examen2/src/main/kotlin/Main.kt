import java.time.LocalDate
import java.util.*

// Main.kt
fun main(){
    var flag = 1
    while (flag != 0){
        println("Seleccione una Opción")
        println("0) Salir")
        println("1) Álbumes")
        println("2) Canciones")
        flag = readln().toInt()
        when (flag){
            (0) -> {
                flag = 0
            }
            (1) -> {
                flag = 1
            }
            (2) -> {
                flag = 1
            }
            else -> println("Opción no válida")

        }
    }


    var fecha = LocalDate.parse("2023-01-09")
    var miCancion = Cancion(1, fecha, "Yonaguni", 2.45f,true, )
    var miAlbum = Album()
    miAlbum.listaCanciones.add(miCancion)
    println(miAlbum.toString())
}