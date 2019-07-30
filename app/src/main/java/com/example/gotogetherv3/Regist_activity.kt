package com.example.gotogetherv3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.gotogetherv3.Regist_frag.Login

class Regist_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regist_activity)


        val fragStart : FragmentTransaction = supportFragmentManager.beginTransaction()
        fragStart.add(R.id.container_regist, Login())
        fragStart.commit()
    }
}
