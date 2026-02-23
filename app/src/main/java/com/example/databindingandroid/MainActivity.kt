package com.example.databindingandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btnCalculadora = findViewById<Button>(R.id.btn_Calculadora)
        val btnLeiDeOhm = findViewById<Button>(R.id.btn_LeiDeOhm)
        btnCalculadora.setOnClickListener {

            val mudarTela = Intent(this, Calculadora::class.java)
            startActivity(mudarTela)
        }

        btnLeiDeOhm.setOnClickListener {
            val MudarTela = Intent(this, LeiDeOhm::class.java)
            startActivity(MudarTela)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}