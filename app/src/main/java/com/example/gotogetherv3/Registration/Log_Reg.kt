package com.example.gotogetherv3.Registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.gotogetherv3.R

class Log_Reg : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log__reg)

        val voity = findViewById<CardView>(R.id.log_reg_voity)
        val registr = findViewById<CardView>(R.id.log_reg_registr)

        voity.setOnClickListener {
            val intent = Intent(this , Login :: class.java)
            startActivity(intent)
        }

        registr.setOnClickListener {
            val intent = Intent(this , Registration :: class.java)
            startActivity(intent)
        }
    }
}
