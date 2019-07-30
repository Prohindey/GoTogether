package com.example.gotogetherv3

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
import com.example.gotogetherv3.Main_frag.Cards
import com.example.gotogetherv3.Main_frag.Chats
import com.example.gotogetherv3.Main_frag.Search
import com.example.gotogetherv3.Main_frag.User_profile
import com.example.gotogetherv3.Regist_frag.Login
import com.example.gotogetherv3.Registration.Log_Reg
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        var sharPer : SharedPreferences = this.getSharedPreferences("User_data", Context.MODE_PRIVATE)
        val data_email = sharPer.getString("mail","")
        val data_pas = sharPer.getString("pass", "")

        if (data_email  == null || data_pas == null){
            val intent = Intent( this, Log_Reg::class.java)
            startActivity(intent)
        }



        val text = findViewById<TextView>(R.id.main_toolbar_text)
        val icon = findViewById<ImageView>(R.id.main_user_icon)
        val cont = findViewById<CardView>(R.id.main_user_icon_cont)
        val search_edit = findViewById<EditText>(R.id.search_edit)
        val search_icon = findViewById<ImageView>(R.id.search_icon)

        val icon_search = findViewById<ImageView>(R.id.main_menu_search)
        val icon_cards = findViewById<ImageView>(R.id.main_menu_cards)
        val icon_chat = findViewById<ImageView>(R.id.main_menu_chat)

        val icon_search_cont = findViewById<FrameLayout>(R.id.main_menu_search_cont)
        val icon_cards_cont = findViewById<FrameLayout>(R.id.main_menu_cards_cont)
        val icon_chat_cont = findViewById<FrameLayout>(R.id.main_menu_chat_cont)

        val icon_search_set = findViewById<ImageView>(R.id.serch_setting_icon)

        icon_search.setImageResource(R.drawable.main_icon_search_gray)
        icon_cards.setImageResource(R.drawable.main_icon_cards_violet)
        icon_chat.setImageResource(R.drawable.main_icon_chat_gray)

        val fragStart : FragmentTransaction = supportFragmentManager.beginTransaction()
        fragStart.replace(R.id.main_cont, Cards())
        fragStart.commit()

        text.visibility = View.VISIBLE
        icon.visibility = View.VISIBLE
        cont.visibility = View.VISIBLE

        search_edit.visibility = View.INVISIBLE
        search_icon.visibility = View.INVISIBLE

        text.text = "Для вас"


        Glide.with(this).load("https://pp.userapi.com/c846021/v846021543/101da/eOtepAK0QNQ.jpg").into(icon)

        icon.setOnClickListener {


            search_edit.visibility = View.INVISIBLE
            search_icon.visibility = View.INVISIBLE
            icon_search_set.visibility = View.INVISIBLE

            text.text = "Профиль"


            val fragStart : FragmentTransaction = supportFragmentManager.beginTransaction()
            fragStart.replace(R.id.main_cont, User_profile())
            fragStart.commit()
        }





        icon_search_cont.setOnClickListener {
            icon_search.setImageResource(R.drawable.main_icon_search_violet)
            icon_cards.setImageResource(R.drawable.main_icon_cards_gray)
            icon_chat.setImageResource(R.drawable.main_icon_chat_gray)

            val fragStart : FragmentTransaction = supportFragmentManager.beginTransaction()
            fragStart.replace(R.id.main_cont, Search())
            fragStart.commit()

            text.visibility = View.INVISIBLE
            icon.visibility = View.INVISIBLE
            cont.visibility = View.INVISIBLE

            search_edit.visibility = View.VISIBLE
            search_icon.visibility = View.VISIBLE
            icon_search_set.visibility = View.VISIBLE


        }

        icon_cards_cont.setOnClickListener {
            icon_search.setImageResource(R.drawable.main_icon_search_gray)
            icon_cards.setImageResource(R.drawable.main_icon_cards_violet)
            icon_chat.setImageResource(R.drawable.main_icon_chat_gray)

            val fragStart : FragmentTransaction = supportFragmentManager.beginTransaction()
            fragStart.replace(R.id.main_cont, Cards())
            fragStart.commit()

            text.visibility = View.VISIBLE
            icon.visibility = View.VISIBLE
            cont.visibility = View.VISIBLE

            search_edit.visibility = View.INVISIBLE
            search_icon.visibility = View.INVISIBLE
            icon_search_set.visibility = View.INVISIBLE

            text.text = "Для вас"



        }

        icon_chat_cont.setOnClickListener {
            icon_search.setImageResource(R.drawable.main_icon_search_gray)
            icon_cards.setImageResource(R.drawable.main_icon_cards_gray)
            icon_chat.setImageResource(R.drawable.main_icon_chat_violet)

            val fragStart : FragmentTransaction = supportFragmentManager.beginTransaction()
            fragStart.replace(R.id.main_cont, Chats())
            fragStart.commit()

            text.visibility = View.VISIBLE
            icon.visibility = View.VISIBLE
            cont.visibility = View.VISIBLE

            search_edit.visibility = View.INVISIBLE
            search_icon.visibility = View.INVISIBLE
            icon_search_set.visibility = View.INVISIBLE


            text.text = "Сообщения"


        }





//        val nav_bot = findViewById<BottomNavigationView>(R.id.bot_nav_view)
//
//        nav_bot.setOnNavigationItemSelectedListener {
//            menuItem ->
//                when (menuItem.itemId){
//                    R.id.nav_recomendation -> {
//
//
//                        search_cont.visibility = View.INVISIBLE
//                        val fragStart : FragmentTransaction = supportFragmentManager.beginTransaction()
//                        fragStart.replace(R.id.main_cont, Cards())
//                        fragStart.commit()
//                        true
//                    }
//                    R.id.nav_chats -> {
//                        text.visibility = View.VISIBLE
//                        icon.visibility = View.VISIBLE
//                        cont.visibility = View.VISIBLE
//                        search_edit.visibility = View.INVISIBLE
//                        search_icon.visibility = View.INVISIBLE
//                        search_cont.visibility = View.INVISIBLE
//                        text.text = "Сообщения"
//                        val fragStart : FragmentTransaction = supportFragmentManager.beginTransaction()
//                        fragStart.replace(R.id.main_cont, Chats())
//                        fragStart.commit()
//                        true
//                    }
//                    R.id.nav_search -> {
//                        text.visibility = View.INVISIBLE
//                        icon.visibility = View.INVISIBLE
//                        cont.visibility = View.INVISIBLE
//                        search_edit.visibility = View.VISIBLE
//                        search_icon.visibility = View.VISIBLE
//                        search_cont.visibility = View.VISIBLE
//                        val fragStart : FragmentTransaction = supportFragmentManager.beginTransaction()
//                        fragStart.replace(R.id.main_cont, Search())
//                        fragStart.commit()
//                        true
//                    }
//                    else -> false
//                }
//        }


//        val intent = Intent(this, Regist_activity::class.java)
//        startActivity(intent)








    }
}
