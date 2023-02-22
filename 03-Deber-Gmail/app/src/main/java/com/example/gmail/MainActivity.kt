package com.example.gmail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gmail.adapter1.PerfilAdapter
import com.example.gmail.ui.home.CorreoProvider
import com.example.gmail.ui.home.adapter.CorreoAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIrPantallaPrincipal: Button = findViewById(R.id.btn_ir_pag_principal)
        btnIrPantallaPrincipal
            .setOnClickListener{
                irActividad(Pag_principal::class.java)
            }
        initRecyclerView()
    }

    fun irActividad(
        clase: Class<*>
    ) {
        val intent = Intent(this, clase)
        startActivity(intent)
    }

    fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_perfiles)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PerfilAdapter(PerfilProvider.perfilesList)
    }
}