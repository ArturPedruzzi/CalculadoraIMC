package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnCalcular: Button = findViewById<Button>(R.id.btncalcular)
        val edtPeso: EditText = findViewById(R.id.edt_peso)
        val edtAltura: EditText = findViewById(R.id.edt_altura)


        btnCalcular.setOnClickListener {

            val pesoStr = edtPeso.text.toString()
            val alturaStr = edtAltura.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {
                val altura: Float = alturaStr.toFloat()
                val peso: Float = pesoStr.toFloat()


                val alturafinal: Float = altura * altura
                val result: Float = peso / alturafinal


                val intent = Intent(this, ResultActivity::class.java)

                    .apply {
                        putExtra("RESULT_EXTRA", result)
                    }
                startActivity(intent)
            } else {
                Toast.makeText( this, "Preencher todos os campos", Toast.LENGTH_LONG).show()
            }

        }

    }

}