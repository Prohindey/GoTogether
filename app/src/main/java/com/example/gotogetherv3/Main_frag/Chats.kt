package com.example.gotogetherv3.Main_frag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gotogetherv3.Adapter.Chats
import com.example.gotogetherv3.Data.Chat
import com.example.gotogetherv3.R

class Chats : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       val v = inflater.inflate(R.layout.frag_chats, container, false)


        val rec = v.findViewById<RecyclerView>(R.id.chats_rec)

        val caht_list : ArrayList<Chat> = arrayListOf(Chat("0","Tola","KyKy", "https://pp.userapi.com/c841521/v841521431/bc34/9dT9sbyU1AM.jpg"), Chat("1", "Valek", "KORG", "https://pp.userapi.com/c824409/v824409239/114ad8/1iHSOPyPrVw.jpg"))





        rec.layoutManager = LinearLayoutManager(v.context)
        val adapter = Chats(caht_list)
        rec.adapter = adapter

        return v
    }




}