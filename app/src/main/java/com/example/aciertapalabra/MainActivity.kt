package com.example.aciertapalabra

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var buttonEnviarNombre : Button
    private lateinit var editTextNombre : EditText
    private lateinit var textViewNombre : TextView
    private var listaPalabras= listOf("Jesus", "Adios", "Roblox", "Garen")
    private var palabra = ""

    /* Inicia los elementos buscandolos por su id */
    private fun iniciarElementos() {
        buttonEnviarNombre = findViewById(R.id.buttonEnviarNombre)
        editTextNombre = findViewById(R.id.escribeTuNombre)
        textViewNombre = findViewById(R.id.textViewPalabra)
    }

    private fun elegirPalabra() {
        this.palabra=listaPalabras.random()
    }

    private fun validar(){
        buttonEnviarNombre.setOnClickListener { view_ ->
            if( editTextNombre.text.length<5){
                Toast.makeText(this, "Tamaño inferior a 5 caracteres", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Boton pulsado", Toast.LENGTH_SHORT).show()

                val intento = editTextNombre.text
                var num=0
                var newText = ""

                for (letra in palabra) {
                    if(intento.getOrNull(num)==letra){
                        newText+=letra+" "
                    }else{
                        newText+="_ "
                    }
                    num++
                }

                textViewNombre.text = newText
                editTextNombre.text.clear()
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        iniciarElementos()
        elegirPalabra()
        validar()
    }


}