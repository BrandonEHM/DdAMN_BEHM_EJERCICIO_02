package com.example.behm_02

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Para cargar o mostrar el diseño - linear Layout
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referencia a los EditText, Buttons y TextView del diseño
        val etNum1 = findViewById<EditText>(R.id.etNum1)
        val etNum2 = findViewById<EditText>(R.id.etNum2)
        val btSuma = findViewById<Button>(R.id.btSuma)
        val btResta = findViewById<Button>(R.id.btResta)
        val btMult = findViewById<Button>(R.id.btMult)
        val btDiv = findViewById<Button>(R.id.btDiv)
        val btBorrar = findViewById<Button>(R.id.btBorrar)
        val tvResultado = findViewById<TextView>(R.id.tvEtiquetaResultado)

        // Función para obtener el valor del EditText y manejar la conversión a número
        fun getInputValue(editText: EditText): Double? {
            return editText.text.toString().toDoubleOrNull()
        }

        // Operaciones básicas
        btBorrar.setOnClickListener {
            etNum1.text.clear()
            etNum2.text.clear()
            tvResultado.text = ""
            Toast.makeText(this, "Datos borrados", Toast.LENGTH_SHORT).show()

        }

        // Operaciones básicas
        btSuma.setOnClickListener {
            val num1 = getInputValue(etNum1)
            val num2 = getInputValue(etNum2)

            if (num1 == null || num2 == null) {
                tvResultado.text = "Ingrese valores válidos"
                Toast.makeText(this, "Ingrese valores válidos", Toast.LENGTH_LONG).show()
            } else {
                val resultado = num1 + num2
                tvResultado.text = resultado.toString()
            }
        }

        btResta.setOnClickListener {
            val num1 = getInputValue(etNum1)
            val num2 = getInputValue(etNum2)

            if (num1 == null || num2 == null) {
                tvResultado.text = "Ingrese valores válidos"
                Toast.makeText(this, "Ingrese valores válidos", Toast.LENGTH_LONG).show()
            } else {
                val resultado = num1 - num2
                tvResultado.text = resultado.toString()
            }
        }

        btMult.setOnClickListener {
            val num1 = getInputValue(etNum1)
            val num2 = getInputValue(etNum2)

            if (num1 == null || num2 == null) {
                tvResultado.text = "Ingrese valores válidos"
                Toast.makeText(this, "Ingrese valores válidos", Toast.LENGTH_LONG).show()
            } else {
                val resultado = num1 * num2
                tvResultado.text = resultado.toString()
            }
        }

        btDiv.setOnClickListener {
            val num1 = getInputValue(etNum1)
            val num2 = getInputValue(etNum2)

            if (num1 == null || num2 == null) {
                tvResultado.text = "Ingrese valores válidos"
                Toast.makeText(this, "Ingrese valores válidos", Toast.LENGTH_LONG).show()
            } else if (num2 == 0.0) {
                Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT).show()
                tvResultado.text = "No se puede dividir entre 0"
            } else {
                val resultado = num1 / num2
                tvResultado.text = resultado.toString()

            }
        }
    }
}
