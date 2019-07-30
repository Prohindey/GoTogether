package com.example.gotogetherv3


import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.gotogetherv3.Full_card_frag.Full_card_frag
import com.example.gotogetherv3.Regist_frag.Login

class Full_card_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.full_card_activity)

        val ID = intent.getStringExtra("ID")

        val but_like  = findViewById<ImageView>(R.id.full_card_like)
        val but_people = findViewById<ImageView>(R.id.full_card_people)

        val fragStart : FragmentTransaction = supportFragmentManager.beginTransaction()
        val bund = Bundle()
        bund.putString("ID", ID)
        val frag = Full_card_frag()
        frag.arguments = bund
        fragStart.add(R.id.full_card_container, frag)
        fragStart.commit()

        but_like.setOnClickListener {


        }

        but_people.setOnClickListener {



        }
    }
}
