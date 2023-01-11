import java.io.*
import java.time.LocalDate
import java.util.*


// Main.kt
fun main(){
    var flag = true
    while (flag){
        println("Seleccione una Opción")
        println("0. Salir")
        println("1. Álbumes")
        println("2. Canciones")
        var opcion = readln().toInt()
        when (opcion){
            (0) -> {
                flag = false
            }
            (1) -> {
                flag = true
                abrirMenuAlbum()
            }
            (2) -> {
                abrirMenuCancion()
            }
            else -> println("Opción no válida")
        }
    }


    var fecha = LocalDate.parse("2023-01-09")
    var miCancion = Cancion(1, fecha, "Yonaguni", 2.45f, true)
    var miCancion2 = Cancion(2, fecha, "Mi verdad", 3f, false)
    var miAlbum = Album()
    miAlbum.listaCanciones.add(miCancion)
    miAlbum.listaCanciones.add(miCancion2)
    println(miAlbum.toString())
}

fun abrirMenuAlbum(){
    var flag2 = true
    while(flag2){
        println("¿Qué desea hacer?")
        println("0. Salir")
        println("1. Crear un album")
        println("2. Listar albumes")
        println("3. Actualizar un album")
        println("4. Eliminar un album")
        var opcion = readln().toInt()
        when (opcion){
            (0) -> {
                flag2 = false
            }
            (1) -> {
                crearAlbum()
            }
            (2) -> {
                abrirMenuCancion()
            }
            (3) -> {

            }
            (4) -> {

            }
            else -> println("Opción no válida")
        }
    }
}

fun crearAlbum(){
    var archivo: File? = null
    var fr: FileReader? = null
    var br: BufferedReader? = null
    /*val nombreArchivo = "albumes.txt"
    val data = "..text to add.."*/
    try {
        archivo = File("Albumes.txt")
        fr = FileReader(archivo)
        br = BufferedReader(fr)
        var linea: String
        while (br.readLine().also { linea = it } != null) {
            val tokens = StringTokenizer(linea, ",")
            var dato: String = tokens.nextToken()
            val nuevoAlbum = Album()
            nuevoAlbum.numCanciones = dato.toInt()
            dato = tokens.nextToken()
            nuevoAlbum.fechaLanzamiento = LocalDate.parse(dato)
            dato = tokens.nextToken()
            nuevoAlbum.nombre = dato
            dato = tokens.nextToken()
            nuevoAlbum.duracionTotal = dato.toFloat()
            dato = tokens.nextToken()
            nuevoAlbum.esDebut = dato.toBoolean()
            dato = tokens.nextToken()
            // aquí se debe añadir una lista de canciones
        }

    } catch (e: IOException) {
        e.printStackTrace()
    }
}
fun abrirMenuCancion(){
    var flag2 = true
    while(flag2){
        println("¿Qué desea hacer?")
        println("0. Salir")
        println("1. Crear una cancion")
        println("2. Listar canciones")
        println("3. Actualizar una cancion")
        println("4. Eliminar una cancion")
        var opcion = readln().toInt()
        when (opcion){
            (0) -> {
                flag2 = false
            }
            (1) -> {
                agregarCancion()
            }
            (2) -> {
                leerCanciones()
                println("\n")
            }
            (3) -> {
                actualizarCancion()
            }
            (4) -> {
                eliminarCancion()
            }
            else -> println("Opción no válida")
        }
    }
}

fun agregarCancion(){
    var miCancion = Cancion()
    var archivo: File?
    var fw: FileWriter? = null
    var pw: PrintWriter?
    // Obtener los datos de la canción
    print("Escriba el id de la cancion: ")
    miCancion.id = readln().toInt()
    print("Escriba la fecha de estreno de la canción (yy-mm-dd): ")
    miCancion.fechaEstreno = LocalDate.parse(readln())
    print("Escriba el nombre de la canción: ")
    miCancion.nombre = readln()
    print("Escriba la duración de la canción: ")
    miCancion.duracion = readln().toFloat()
    print("Escriba V si la canción tiene contenido explícito. Caso contrario, escriba F: ")
    miCancion.esExplicita = readln() == "V"
    try {
        archivo = File("Canciones.txt")
        fw = FileWriter(archivo, true)
        pw = PrintWriter(fw)
        //
        pw.println(miCancion.obtenerAtributos())

    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        try {
            fw?.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
fun leerCanciones(){
    val listaCanciones = mutableListOf<Cancion>()
    var archivo: File? = null
    var fr: FileReader? = null
    var br: BufferedReader? = null
    try {
        val file = File("Canciones.txt")
        val reader = BufferedReader(FileReader(file, Charsets.UTF_8))
        reader.lines().forEach {
            val tokens = StringTokenizer(it, ",")
            var dato: String = tokens.nextToken()
            val nuevaCancion = Cancion()
            nuevaCancion.id = dato.toInt()
            dato = tokens.nextToken()
            nuevaCancion.fechaEstreno = LocalDate.parse(dato)
            dato = tokens.nextToken()
            nuevaCancion.nombre = dato
            dato = tokens.nextToken()
            nuevaCancion.duracion = dato.toFloat()
            dato = tokens.nextToken()
            nuevaCancion.esExplicita = dato.toBoolean()
            listaCanciones.add(nuevaCancion)
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }
    println(listaCanciones)
}
fun actualizarCancion(){
    val listaCanciones = mutableListOf<Cancion>()
    println("Introduzca el ID de la cancion que desea actualizar")
    val id = readln().toInt()
    // Lee el archivo y genera una lista con las canciones actuales
    val file = File("Canciones.txt")
    val reader = BufferedReader(FileReader(file, Charsets.UTF_8))
    reader.lines().forEach {
        val tokens = StringTokenizer(it, ",")
        var dato: String = tokens.nextToken()
        val nuevaCancion = Cancion()
        nuevaCancion.id = dato.toInt()
        dato = tokens.nextToken()
        nuevaCancion.fechaEstreno = LocalDate.parse(dato)
        dato = tokens.nextToken()
        nuevaCancion.nombre = dato
        dato = tokens.nextToken()
        nuevaCancion.duracion = dato.toFloat()
        dato = tokens.nextToken()
        nuevaCancion.esExplicita = dato.toBoolean()
        listaCanciones.add(nuevaCancion)
    }
    var cancionAux = Cancion()
    listaCanciones.forEach {
        if (it.id == id){
            cancionAux = it
        }
    }
    val indiceCancion = listaCanciones.indexOf(cancionAux)
    // Eliminamos la cancion anterior
    listaCanciones.remove(cancionAux)
    // Actualizamos la cancion
    print("Escriba el nuevo nombre de la canción: ")
    cancionAux.nombre = readln()
    print("Escriba la nueva fecha de la canción: ")
    cancionAux.fechaEstreno = LocalDate.parse(readln())
    print("Escriba la nueva duración de la canción: ")
    cancionAux.duracion = readln().toFloat()
    print("Escriba V si la canción tiene contenido explícito. Caso contrario, escriba F: ")
    cancionAux.esExplicita = readln() == "V"
    // Añadimos la cancion actualizada
    listaCanciones.add(indiceCancion, cancionAux)

    println(listaCanciones)

    // Vamos a reescribir toodo el archivo
    var archivo: File?
    var fw: FileWriter? = null
    var pw: PrintWriter?
    try {
        archivo = File("Canciones.txt")
        fw = FileWriter(archivo)
        pw = PrintWriter(fw)
        listaCanciones.forEach {
            pw.println(it.obtenerAtributos())
        }
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        try {
            fw?.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

fun eliminarCancion(){
    val listaCanciones = mutableListOf<Cancion>()
    println("Introduzca el ID de la cancion que desea eliminar")
    val id = readln().toInt()
    // Lee el archivo y genera una lista con las canciones actuales
    val file = File("Canciones.txt")
    val reader = BufferedReader(FileReader(file, Charsets.UTF_8))
    reader.lines().forEach {
        val tokens = StringTokenizer(it, ",")
        var dato: String = tokens.nextToken()
        val nuevaCancion = Cancion()
        nuevaCancion.id = dato.toInt()
        dato = tokens.nextToken()
        nuevaCancion.fechaEstreno = LocalDate.parse(dato)
        dato = tokens.nextToken()
        nuevaCancion.nombre = dato
        dato = tokens.nextToken()
        nuevaCancion.duracion = dato.toFloat()
        dato = tokens.nextToken()
        nuevaCancion.esExplicita = dato.toBoolean()
        listaCanciones.add(nuevaCancion)
    }
    var cancionAux = Cancion()
    listaCanciones.forEach {
        if (it.id == id){
            cancionAux = it
        }
    }
    listaCanciones.remove(cancionAux)
    // Ya se tiene una lista sin el elemento
    // Vamos a reescribir toodo el archivo
    var archivo: File?
    var fw: FileWriter? = null
    var pw: PrintWriter?
    try {
        archivo = File("Canciones.txt")
        fw = FileWriter(archivo)
        pw = PrintWriter(fw)
        listaCanciones.forEach {
            pw.println(it.obtenerAtributos())
        }
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        try {
            fw?.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}