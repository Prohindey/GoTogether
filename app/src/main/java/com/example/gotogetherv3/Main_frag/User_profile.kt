package com.example.gotogetherv3.Main_frag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gotogetherv3.Adapter.User_profile
import com.example.gotogetherv3.Data.Event
import com.example.gotogetherv3.R

class User_profile: Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.user_profile_frag, container, false)

        val name = v.findViewById<TextView>(R.id.user_profile_name)
        val age = v.findViewById<TextView>(R.id.user_profile_age)
        val chat = v.findViewById<TextView>(R.id.user_profile_text_chat)
        val events = v.findViewById<TextView>(R.id.user_profile_text_chat)
        val dis = v.findViewById<TextView>(R.id.user_profile_text_dis)
        val rec = v.findViewById<RecyclerView>(R.id.user_profile_rec)
        val photo = v.findViewById<ImageView>(R.id.user_profile_photo)
        val like : ArrayList<Event> = ArrayList()



        val t_name = "Вжик"
        val t_age = "19"
        val t_chat = "1"
        val t_events = "3"
        val t_dis = "Brony one love"
        var photo_list: ArrayList<String> = ArrayList(); photo_list.add("https://wegotthiscovered.com/wp-content/uploads/2018/01/harry-potter-ar-game.jpg")
        var interes : ArrayList<String> = arrayListOf("Театр и кино", "Юмор", "Игры и квесты", "Романтика и активный отдых")

        like.add(Event(0.toString(),"Вписка", "101", "12.12.12", "12:00", "100p", photo_list, interes))

        Glide.with(v.context).load("https://pp.userapi.com/c846021/v846021543/101da/eOtepAK0QNQ.jpg").into(photo)

        rec.layoutManager = LinearLayoutManager(v.context)
        val adapter = User_profile(like)
        rec.adapter = adapter


        return v
    }


}