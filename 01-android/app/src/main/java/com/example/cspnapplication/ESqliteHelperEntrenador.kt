package com.example.cspnapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ESqliteHelperEntrenador (
    contexto: Context?, // THIS
): SQLiteOpenHelper (
    contexto,
    "moviles", // nombre BDD
    null,
    1
){
    override fun onCreate(db: SQLiteDatabase?) {
        val scriptSQLCrearTablaEntrenador =
            """
                CREATE TABLE ENTRENADOR(
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre VARCHAR(50),
                descripcion VARCHAR(50)
                )
            """.trimIndent()
        db?.execSQL(scriptSQLCrearTablaEntrenador)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }

    fun crearEntrenador(
        nombre: String,
        descripcion: String
    ): Boolean {
        val baseDatosEscritura = writableDatabase
        val valoresAGuardar = ContentValues()
        valoresAGuardar.put("nombre", nombre)
        valoresAGuardar.put("descripcion", descripcion)
        val resultadoGuardar = baseDatosEscritura
            .insert(
                "ENTRENADOR", // Nombre tabla
                null,
                valoresAGuardar // valores
            )
        baseDatosEscritura.close()
        return if(resultadoGuardar.toInt() == -1) false else true
    }

    fun eliminarEntrenadorFormulario(id: Int): Boolean{
        //
        val conexionEscritura = writableDatabase
        //
        //
        //
        //
        val resultadoEliminacion = conexionEscritura
            .delete(
                "ENTRENADOR", // Nombre tabla
            "id=?",      // Consulta Where
            arrayOf(
                id.toString()
            ) // Parametros
        )
    conexionEscritura.close()
    return if (resultadoEliminacion.toInt() == -1) false else true
    }
}