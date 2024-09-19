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
    private var palabra = "listaPalabras."

    /* Inicia los elementos buscandolos por su id */
    private fun iniciarElementos() {
        buttonEnviarNombre = findViewById(R.id.buttonEnviarNombre)
        editTextNombre = findViewById(R.id.escribeTuNombre)
        textViewNombre = findViewById(R.id.textViewPalabra)
    }
    private fun validar(){
        buttonEnviarNombre.setOnClickListener { view_ ->
            if( editTextNombre.text.length<2){
                Toast.makeText(this, "Tamaño inferior a 2 caracteres", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Boton pulsado", Toast.LENGTH_SHORT).show()
                textViewNombre.text = editTextNombre.text
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
        validar()
    }
}