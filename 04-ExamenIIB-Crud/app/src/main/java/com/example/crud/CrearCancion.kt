package com.example.crud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class CrearCancion : AppCompatActivity() {
    private var database = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        database = FirebaseFirestore.getInstance()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_cancion)

        val tituloCancion = findViewById<EditText>(R.id.et_titulo)
        val artista  = findViewById<EditText>(R.id.et_artista)
        val anio  = findViewById<EditText>(R.id.et_anio)
        val lanzamiento  = findViewById<EditText>(R.id.et_lanzamiento)

        val btnAgregarCancion = findViewById<Button>(R.id.btn_agregar_album)
        btnAgregarCancion.setOnClickListener {
            if (tituloCancion.text.isNotEmpty()
                && artista.text.isNotEmpty()
                && anio.text.isNotEmpty()
                && lanzamiento.text.isNotEmpty()
            ){
                val lanzamientoString = lanzamiento.text.toString()
                val esLanzamiento = lanzamientoString.toBoolean()


                val data = hashMapOf(
                    "titulo" to tituloCancion.text.toString(),
                    "lanzamiento" to esLanzamiento,
                    "anio" to anio.text.toString(),
                    "artista" to artista.text.toString()
                )

                database.collection("Cancion").add(data).
                addOnSuccessListener {
                    Toast.makeText(this, "Ha añadido una canción", Toast.LENGTH_SHORT).show()
                    irActividad(AlbumMain::class.java)
                }.addOnFailureListener {
                    Toast.makeText(this, "Error al crear la canción", Toast.LENGTH_SHORT).show()
                    irActividad(AlbumMain::class.java)
                }
            }
        }
    }

    private fun irActividad(
        activity: Class<*>
    ){
        val intent = Intent(this, activity)
        startActivity(intent)
    }
}