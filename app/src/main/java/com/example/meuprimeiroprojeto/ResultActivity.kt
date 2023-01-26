package com.example.meuprimeiroprojeto

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {


    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar!!.setDefaultDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)




        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_Classificacao)
        val result = intent.getFloatExtra("RESULT_EXTRA", 0.1f )


        tvResult.text = result.toString()

       /*
          MENOR QUE 18.5    ABAIXO DO PESO
          ENTRE 18.5 E 24.9 NORMAL
          ENTRE 25.0 E 29.9 SOBREPESO
          ENTRE 30.0 E 39,9 OBESIDADE
          MAIOR QUE 40,0    OBESIDADE GRAVE
          */

        val classificacao = if(result < 18.5f) {
            "ABAIXO DO PESO"
       }else if(result in 18.5f..24.9f){
            "NORMAL"
       }else if(result in 25f..29.9f){
            "SOBREPESO"
       }else if(result in 30f..39.9f){
            "OBESIDADE"
       }else{
            "OBESIDADE GRAVE"
       }

       tvClassificacao.text = getString(R.string.mensagem_classificacao, classificacao)


      }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }


     }