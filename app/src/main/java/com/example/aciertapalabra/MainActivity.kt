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
    private lateinit var textViewIntentos : TextView
    private lateinit var textViewPremio : TextView

    private var listaPalabras= listOf("Jesus", "Adios", "Roble", "Garen")
    private var palabra = ""
    private var terminado= false
    private var intentos=5

    /* Inicia los elementos buscandolos por su id */
    private fun iniciarElementos() {
        buttonEnviarNombre = findViewById(R.id.buttonEnviarNombre)
        editTextNombre = findViewById(R.id.escribeTuNombre)
        textViewNombre = findViewById(R.id.textViewPalabra)
        textViewIntentos= findViewById(R.id.textViewIntentos)
        textViewPremio= findViewById(R.id.textViewPremio)
    }

    private fun elegirPalabra() {
        this.palabra=listaPalabras.random()
    }

    private fun validar(){
        buttonEnviarNombre.setOnClickListener { view_ ->
            if(!terminado){
                if( editTextNombre.text.length!=5 ){
                    Toast.makeText(this, "Tamaño distinto a 5 caracteres", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"Validando...", Toast.LENGTH_SHORT).show()
                    val intento = editTextNombre.text
                    var num=0
                    var newText = ""

                    if(intento.toString()==palabra){
                        textViewNombre.text = palabra
                        terminado=true
                        buttonEnviarNombre.isEnabled=false
                        editTextNombre.text.clear()
                        editTextNombre.isEnabled=false
                        textViewPremio.visibility=TextView.VISIBLE
                        intentos--
                        textViewIntentos.text = intentos.toString() + " intentos"
                    }else{
                        for (letra in palabra) {
                            if(intento.getOrNull(num)==letra){
                                newText+=letra+" "
                            }else{
                                newText+="_ "
                            }
                            num++
                        }
                        intentos--
                        if(intentos==0){
                            terminado=true
                            buttonEnviarNombre.isEnabled=false
                            editTextNombre.isEnabled=false
                        }
                        textViewIntentos.text = intentos.toString() + " intentos"
                        textViewNombre.text = newText
                        editTextNombre.text.clear()
                    }
                }
            }else{

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