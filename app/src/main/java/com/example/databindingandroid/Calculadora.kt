package com.example.databindingandroid

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Calculadora : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_calculadora)
        val txtMensagem = findViewById<TextView>(R.id.txt_Mensagem)
        val txtResultado = findViewById<TextView>(R.id.txt_Resultado)
        val edtPrimeiraEntrada = findViewById<EditText>(R.id.etd_PrimeiraEntrada)
        val edtSegundaEntrada = findViewById<EditText>(R.id.etd_SegundaEntrada)
        val btnSomar = findViewById<Button>(R.id.btn_Somar)
        val btnSubitrair = findViewById<Button>(R.id.btn_Subitrair)
        val btnMultiplicar = findViewById<Button>(R.id.btn_Multiplicar)
        val btnDividir = findViewById<Button>(R.id.btn_Dividir)
        val btnResultad = findViewById<Button>(R.id.btn_Resultado)
        val btnLimpar   = findViewById<Button>(R.id.btn_limpar)
        var escolha = 0
        val ms ="Digite o primeiro número antes!"

        btnLimpar.setOnClickListener {
            edtPrimeiraEntrada.text.clear()

            edtSegundaEntrada.text.clear()
            txtMensagem.text = ""
            txtResultado.text ="0"
            escolha = 0
        }

        btnSomar.setOnClickListener {
            if(edtPrimeiraEntrada.text.isBlank()){
                edtPrimeiraEntrada.error = ms
            }
            else{escolha = 1
                edtSegundaEntrada.requestFocus()
                txtMensagem.setTextColor(android.graphics.Color.WHITE)
                txtMensagem.text = "${edtPrimeiraEntrada.text}+"
            }
        }
        btnSubitrair.setOnClickListener {
            if(edtPrimeiraEntrada.text.isBlank()){
                edtPrimeiraEntrada.error = ms
            }else{escolha = 2
                edtSegundaEntrada.requestFocus()
                txtMensagem.setTextColor(android.graphics.Color.WHITE)
                txtMensagem.text = "${edtPrimeiraEntrada.text}-"
            }
        }
        btnMultiplicar.setOnClickListener {
            if(edtPrimeiraEntrada.text.isBlank()){
                edtPrimeiraEntrada.error = ms
            }else{escolha = 3
                edtSegundaEntrada.requestFocus()
                txtMensagem.setTextColor(android.graphics.Color.WHITE)
                txtMensagem.text = "${edtPrimeiraEntrada.text}*"
            }
        }
        btnDividir.setOnClickListener {
            if(edtPrimeiraEntrada.text.isBlank()){
                edtPrimeiraEntrada.error = ms
            }else{escolha = 4
                edtSegundaEntrada.requestFocus()
                txtMensagem.setTextColor(android.graphics.Color.WHITE)
                txtMensagem.text = "${edtPrimeiraEntrada.text}/"
            }
        }

        btnResultad.setOnClickListener {
            val Primeiro = edtPrimeiraEntrada.text.toString()
            val Segundo = edtSegundaEntrada.text.toString()
            txtMensagem.setTextColor(android.graphics.Color.WHITE)

            if(Primeiro.isEmpty() || Segundo.isEmpty()){
                txtResultado.text = "0"
                txtMensagem.text = "0="
                edtPrimeiraEntrada.requestFocus()

            }
            else{
                val n1 = Primeiro.toDouble()
                val n2 = Segundo.toDouble()

                var resultadoNumero: Double? = null
                var mensagem :String? = null

                when (escolha){
                    1->{resultadoNumero = n1 + n2
                        txtMensagem.text = "${txtMensagem.text}${edtSegundaEntrada.text}="
                    }
                    2->{resultadoNumero = n1 - n2
                        txtMensagem.text = "${txtMensagem.text}${edtSegundaEntrada.text}="
                    }
                    3->{resultadoNumero = n1 * n2
                        txtMensagem.text = "${txtMensagem.text}${edtSegundaEntrada.text}="
                    }
                    4->{if(n2!=0.0) {
                        resultadoNumero = n1 / n2
                        txtMensagem.text = "${txtMensagem.text}${edtSegundaEntrada.text}="
                    }else{
                        mensagem= "Não é possível dividir por zero"
                        txtResultado.text ="0"
                    }


                }else-> mensagem = "Operação invalida"

            }
                if(mensagem!= null){
                    txtMensagem.text=mensagem
                    txtResultado.text ="0"
                    txtMensagem.setTextColor(android.graphics.Color.RED)
                }else if(resultadoNumero!= null){
                    if(resultadoNumero % 1 ==0.0){
                        txtResultado.text = resultadoNumero.toLong().toString()
                    }else{
                        txtResultado.text = resultadoNumero.toString()
                    }
                }

                edtPrimeiraEntrada.text.clear()
                edtSegundaEntrada.text.clear()
                edtPrimeiraEntrada.requestFocus()
                escolha = 0

        }

}
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}