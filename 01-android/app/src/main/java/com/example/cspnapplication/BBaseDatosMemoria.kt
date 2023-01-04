package com.example.cspnapplication

class BBaseDatosMemoria {
    companion object {
        val arregloBEntrenador = arrayListOf<BEntrenador>()
        init {
            arregloBEntrenador
                .add(
                    BEntrenador("Cristopher", "a@a.com")
                )
            arregloBEntrenador
                .add(
                    BEntrenador("Santiago", "b@b.com")
                )
            arregloBEntrenador
                .add(
                    BEntrenador("Génesis", "c@c.com")
                )
        }
    }
}