package com.example.triqui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import java.sql.Array

class MainActivity : AppCompatActivity() {

    var jugadas = 0
    var jugador1 = "O"
    var jugador2 = "X"
    var matriz = Array(3) { Array(3) { " " } }
    var uno: Button? = null
    var dos: Button? = null
    var tres: Button? = null
    var cuatro:Button? = null
    var cinco:Button? = null
    var seis:Button? = null
    var siete:Button? = null
    var ocho:Button? = null
    var nueve: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        uno = findViewById<Button>(R.id.button_uno)
        uno?.setOnClickListener {

            matriz[0][0] = calcularOX(uno)
            imprimirMatriz()
            hacerTriqui()

            uno?.isClickable = false
        }


        dos = findViewById<Button>(R.id.button_dos)
        dos?.setOnClickListener {

            matriz[0][1] = calcularOX(dos)
            imprimirMatriz()
            hacerTriqui()

            dos?.isClickable = false
        }

        tres = findViewById<Button>(R.id.button_tres)
        tres?.setOnClickListener {

            matriz[0][2] = calcularOX(tres)
            imprimirMatriz()
            hacerTriqui()
            tres?.isClickable = false

        }

        cuatro = findViewById<Button>(R.id.button_cuatro)
        cuatro?.setOnClickListener {

            matriz[1][0] = calcularOX(cuatro)
            imprimirMatriz()
            hacerTriqui()
            cuatro?.isClickable = false

        }

        cinco = findViewById<Button>(R.id.button_cinco)
        cinco?.setOnClickListener {

            matriz[1][1] = calcularOX(cinco)
            imprimirMatriz()
            hacerTriqui()
            cinco?.isClickable = false
        }

        seis = findViewById<Button>(R.id.button_seis)
        seis?.setOnClickListener {


            matriz[1][2] = calcularOX(seis)
            imprimirMatriz()
            hacerTriqui()
            seis?.isClickable = false

        }

        siete = findViewById<Button>(R.id.button_siete)
        siete?.setOnClickListener {

            matriz[2][0] = calcularOX(siete)
            imprimirMatriz()
            hacerTriqui()
            siete?.isClickable = false
        }

        ocho = findViewById<Button>(R.id.button_ocho)
        ocho?.setOnClickListener {

            matriz[2][1] = calcularOX(ocho)
            imprimirMatriz()
            hacerTriqui()
            ocho?.isClickable = false
        }

        nueve = findViewById<Button>(R.id.button_nueve)
        nueve?.setOnClickListener {

            matriz[2][2] = calcularOX(nueve)
            imprimirMatriz()
            hacerTriqui()
            nueve?.isClickable = false
        }

        val jugar = findViewById<Button>(R.id.buttonJugar)
        jugar.setOnClickListener {

            uno?.text = ""
            dos?.text = ""
            tres?.text = ""
            cuatro?.text = ""
            cinco?.text = ""
            seis?.text = ""
            siete?.text = ""
            ocho?.text = ""
            nueve?.text = ""

            uno?.isClickable = true
            dos?.isClickable = true
            tres?.isClickable = true
            cuatro?.isClickable = true
            cinco?.isClickable = true
            seis?.isClickable = true
            siete?.isClickable = true
            ocho?.isClickable = true
            nueve?.isClickable = true



            for (i in matriz.indices) {
                for (j in matriz[i].indices) {
                    if (matriz[i][j] != " ") {
                        matriz[i][j] = " "
                    }
                }
                Log.e("liz", "")
            }
        }


    }


    fun calcularOX(button: Button?): String {
        if (button?.text.isNullOrEmpty() && jugadas % 2 == 0) {
            jugadas += 1
            button?.text = jugador1

        } else {
            jugadas += 1
            button?.text = jugador2
        }

        return button?.text.toString()

    }


    fun imprimirMatriz() {
        Log.e("liz", "filas => ${matriz.size}")
        Log.e("liz", "columnas => ${matriz.first().size}")

        for (i in matriz) {
            var line = ""
            for (j in i) {
                line = "$line|$j|"

            }
            Log.e("liz", "$line")
        }
    }

    fun hacerTriqui() {

        if (matriz[0][0] == matriz[0][1] && matriz[0][1] == matriz[0][2]) {

            if (matriz[0][0] == jugador1) {

                Toast.makeText(this, "Triqui Jugados O", Toast.LENGTH_SHORT).show()
                Log.e("liz", "triqui $jugador1")
                uno?.isClickable = false
                dos?.isClickable = false
                tres?.isClickable = false
                cuatro?.isClickable = false
                cinco?.isClickable = false
                seis?.isClickable = false
                siete?.isClickable = false
                ocho?.isClickable = false
                nueve?.isClickable = false

            } else if (matriz[0][0] == jugador2) {
                Toast.makeText(this, "Triqui Jugados X", Toast.LENGTH_SHORT).show()
                Log.e("liz", "triqui $jugador2")

                uno?.isClickable = false
                dos?.isClickable = false
                tres?.isClickable = false
                cuatro?.isClickable = false
                cinco?.isClickable = false
                seis?.isClickable = false
                siete?.isClickable = false
                ocho?.isClickable = false
                nueve?.isClickable = false
            }

        }

        if (matriz[1][0] == matriz[1][1] && matriz[1][1] == matriz[1][2]) {

            if (matriz[1][0] == jugador1) {
                Toast.makeText(this, "Triqui Jugados O", Toast.LENGTH_SHORT).show()

                Log.e("liz", "triqui $jugador1")
                uno?.isClickable = false
                dos?.isClickable = false
                tres?.isClickable = false
                cuatro?.isClickable = false
                cinco?.isClickable = false
                seis?.isClickable = false
                siete?.isClickable = false
                ocho?.isClickable = false
                nueve?.isClickable = false


            } else if (matriz[1][0] == jugador2) {
                Toast.makeText(this, "Triqui Jugados X", Toast.LENGTH_SHORT).show()
                Log.e("liz", "triqui $jugador2")
                uno?.isClickable = false
                dos?.isClickable = false
                tres?.isClickable = false
                cuatro?.isClickable = false
                cinco?.isClickable = false
                seis?.isClickable = false
                siete?.isClickable = false
                ocho?.isClickable = false
                nueve?.isClickable = false

            }
        }

        if (matriz[2][0] == matriz[2][1] && matriz[2][1] == matriz[2][2]) {
            if (matriz[2][0] == jugador1) {
                Toast.makeText(this, "Triqui Jugados O", Toast.LENGTH_SHORT).show()
                Log.e("liz", "triqui $jugador1")
                uno?.isClickable = false
                dos?.isClickable = false
                tres?.isClickable = false
                cuatro?.isClickable = false
                cinco?.isClickable = false
                seis?.isClickable = false
                siete?.isClickable = false
                ocho?.isClickable = false
                nueve?.isClickable = false
            } else if (matriz[2][0] == jugador2) {
                Toast.makeText(this, "Triqui Jugados X", Toast.LENGTH_SHORT).show()
                Log.e("liz", "triqui $jugador2")
                uno?.isClickable = false
                dos?.isClickable = false
                tres?.isClickable = false
                cuatro?.isClickable = false
                cinco?.isClickable = false
                seis?.isClickable = false
                siete?.isClickable = false
                ocho?.isClickable = false
                nueve?.isClickable = false
            }
        }

        if (matriz[0][0] == matriz[1][0] && matriz[1][0] == matriz[2][0]) {

            if (matriz[0][0] == jugador1) {
                Toast.makeText(this, "Triqui Jugados O", Toast.LENGTH_SHORT).show()
                Log.e("liz", "triqui $jugador1")
                uno?.isClickable = false
                dos?.isClickable = false
                tres?.isClickable = false
                cuatro?.isClickable = false
                cinco?.isClickable = false
                seis?.isClickable = false
                siete?.isClickable = false
                ocho?.isClickable = false
                nueve?.isClickable = false

            } else if (matriz[0][0] == jugador2) {
                Toast.makeText(this, "Triqui Jugados X", Toast.LENGTH_SHORT).show()
                Log.e("liz", "triqui $jugador2")
                uno?.isClickable = false
                dos?.isClickable = false
                tres?.isClickable = false
                cuatro?.isClickable = false
                cinco?.isClickable = false
                seis?.isClickable = false
                siete?.isClickable = false
                ocho?.isClickable = false
                nueve?.isClickable = false
            }
        }

        if (matriz[0][1] == matriz[1][1] && matriz[1][1] == matriz[2][1]) {

            if (matriz[0][1] == jugador1) {
                Toast.makeText(this, "Triqui Jugados O", Toast.LENGTH_SHORT).show()
                Log.e("liz", "triqui $jugador1")
                uno?.isClickable = false
                dos?.isClickable = false
                tres?.isClickable = false
                cuatro?.isClickable = false
                cinco?.isClickable = false
                seis?.isClickable = false
                siete?.isClickable = false
                ocho?.isClickable = false
                nueve?.isClickable = false
            } else if (matriz[0][1] == jugador2) {
                Toast.makeText(this, "Triqui Jugados X", Toast.LENGTH_SHORT).show()
                Log.e("liz", "triqui $jugador2")
                uno?.isClickable = false
                dos?.isClickable = false
                tres?.isClickable = false
                cuatro?.isClickable = false
                cinco?.isClickable = false
                seis?.isClickable = false
                siete?.isClickable = false
                ocho?.isClickable = false
                nueve?.isClickable = false
            }
        }

        if (matriz[0][2] == matriz[1][2] && matriz[1][2] == matriz[2][2]) {
            if (matriz[0][2] == jugador1) {
                Toast.makeText(this, "Triqui Jugados O", Toast.LENGTH_SHORT).show()
                Log.e("liz", "triqui $jugador1")
                uno?.isClickable = false
                dos?.isClickable = false
                tres?.isClickable = false
                cuatro?.isClickable = false
                cinco?.isClickable = false
                seis?.isClickable = false
                siete?.isClickable = false
                ocho?.isClickable = false
                nueve?.isClickable = false
            } else if (matriz[0][2] == jugador2) {
                Toast.makeText(this, "Triqui Jugados X", Toast.LENGTH_SHORT).show()
                Log.e("liz", "triqui $jugador2")
                uno?.isClickable = false
                dos?.isClickable = false
                tres?.isClickable = false
                cuatro?.isClickable = false
                cinco?.isClickable = false
                seis?.isClickable = false
                siete?.isClickable = false
                ocho?.isClickable = false
                nueve?.isClickable = false
            }
        }

        if (matriz[2][0] == matriz[1][1] && matriz[1][1] == matriz[0][2]) {
            if (matriz[0][2] == jugador1) {
                Toast.makeText(this, "Triqui Jugados O", Toast.LENGTH_SHORT).show()
                Log.e("liz", "triqui $jugador1")
                uno?.isClickable = false
                dos?.isClickable = false
                tres?.isClickable = false
                cuatro?.isClickable = false
                cinco?.isClickable = false
                seis?.isClickable = false
                siete?.isClickable = false
                ocho?.isClickable = false
                nueve?.isClickable = false

            } else if (matriz[0][2] == jugador2) {
                Toast.makeText(this, "Triqui Jugados X", Toast.LENGTH_SHORT).show()
                Log.e("liz", "triqui $jugador2")
                uno?.isClickable = false
                dos?.isClickable = false
                tres?.isClickable = false
                cuatro?.isClickable = false
                cinco?.isClickable = false
                seis?.isClickable = false
                siete?.isClickable = false
                ocho?.isClickable = false
                nueve?.isClickable = false
            }
        }


        if (matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2]) {
            if (matriz[0][0] == jugador1) {
                Toast.makeText(this, "Triqui Jugados O", Toast.LENGTH_SHORT).show()
                Log.e("liz", "triqui $jugador1")
                uno?.isClickable = false
                dos?.isClickable = false
                tres?.isClickable = false
                cuatro?.isClickable = false
                cinco?.isClickable = false
                seis?.isClickable = false
                siete?.isClickable = false
                ocho?.isClickable = false
                nueve?.isClickable = false
            } else if (matriz[0][0] == jugador2) {
                Toast.makeText(this, "Triqui Jugados X", Toast.LENGTH_SHORT).show()
                Log.e("liz", "triqui $jugador2")
                uno?.isClickable = false
                dos?.isClickable = false
                tres?.isClickable = false
                cuatro?.isClickable = false
                cinco?.isClickable = false
                seis?.isClickable = false
                siete?.isClickable = false
                ocho?.isClickable = false
                nueve?.isClickable = false
            }

        }
    }

}









