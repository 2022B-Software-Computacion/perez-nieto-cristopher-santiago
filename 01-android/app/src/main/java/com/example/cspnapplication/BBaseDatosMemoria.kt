package com.example.cspnapplication

class BBaseDatosMemoria {
    companion object {
        val arregloBEntrenador = arrayListOf<BEntrenador>()
        init {
            arregloBEntrenador
                .add(
                    BEntrenador(1, "Cristopher", "a@a.com")
                )
            arregloBEntrenador
                .add(
                    BEntrenador(2, "Santiago", "b@b.com")
                )
            arregloBEntrenador
                .add(
                    BEntrenador(3, "Génesis", "c@c.com")
                )
        }
    }
}