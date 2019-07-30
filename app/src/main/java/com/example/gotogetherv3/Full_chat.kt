package com.example.gotogetherv3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class Full_chat : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_chat)


        val name = findViewById<TextView>(R.id.full_chat_text)
        val img = findViewById<ImageView>(R.id.full_chat_user_icon)
        name.text = intent.getStringExtra("Name")
        Glide.with(this).load(intent.getStringExtra("Img")).into(img)


    }
}
