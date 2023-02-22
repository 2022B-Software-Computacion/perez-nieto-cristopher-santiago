package com.example.gmail.adapter1

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gmail.Perfil
import com.example.gmail.R

class PerfilViewHolder(view: View) : RecyclerView.ViewHolder(view){

    val correoElec = view.findViewById<TextView>(R.id.tv_perfiles)

    fun render(perfilModel: Perfil){
        correoElec.text = perfilModel.correoElectronico
    }
}