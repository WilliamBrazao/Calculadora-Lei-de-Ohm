package com.example.databindingandroid

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LeiDeOhm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_lei_de_ohm)
        val txtResultadoLei = findViewById<TextView>(R.id.txt_ResultadoLei)
        val edtPrimeiroValor = findViewById<EditText>(R.id.edt_PrimeiroValor)
        val edtSegundoValor = findViewById<EditText>(R.id.edt_SegundoValor)
        val btnTenSão = findViewById<Button>(R.id.`btn_Tensão`)
        val btnCorrente = findViewById<Button>(R.id.btn_Corrente)
        val btnResistência = findViewById<Button>(R.id.btn_Resistência)
        val btnLimpar =  findViewById<Button>(R.id.btn_Limpar)
        val msg ="Preencha os dois campos!"


        btnTenSão.setOnClickListener {
            val n1 = edtPrimeiroValor.text.toString().toDoubleOrNull()
            val n2 = edtSegundoValor.text.toString().toDoubleOrNull()

            if (n1 != null && n2 != null) {
                val res = n1 * n2
                val formatado = if (res % 1 == 0.0) res.toLong().toString() else res.toString()
                txtResultadoLei.text = "Tensão: $formatado V"
            } else {
                txtResultadoLei.text = "Preencha os dois campos!"
            }
        }
        btnCorrente.setOnClickListener {
            val n1 = edtPrimeiroValor.text.toString().toDoubleOrNull()
            val n2 = edtSegundoValor.text.toString().toDoubleOrNull()

            if (n1 != null && n2 != null) {
                if (n2 != 0.0) {
                    val res = n1 / n2
                    val formatado = if (res % 1 == 0.0) res.toLong().toString() else res.toString()
                    txtResultadoLei.text = "Corrente: $formatado A"
                } else {
                    txtResultadoLei.text = "A resistência não pode ser 0"
                }
            } else {
                txtResultadoLei.text = msg
            }
        }
        btnResistência.setOnClickListener {

            val n1 = edtPrimeiroValor.text.toString().toDoubleOrNull()
            val n2 = edtSegundoValor.text.toString().toDoubleOrNull()

            if (n1 != null && n2 != null) {
                if (n2 != 0.0) {
                    val res = n1 / n2
                    val formatado = if (res % 1 == 0.0) res.toLong().toString() else res.toString()
                    txtResultadoLei.text = "Resistência: $formatado Ω"
                } else {
                    txtResultadoLei.text = "A corrente não pode ser 0"
                }
            } else {
                txtResultadoLei.text = msg
            }
        }
        btnLimpar.setOnClickListener {
            edtPrimeiroValor.text.clear()
            edtPrimeiroValor.requestFocus()
            edtSegundoValor.text.clear()
            txtResultadoLei.text =""
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}