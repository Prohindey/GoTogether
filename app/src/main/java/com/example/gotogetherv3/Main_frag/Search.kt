package com.example.gotogetherv3.Main_frag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gotogetherv3.Adapter.Card_n
import com.example.gotogetherv3.Data.Event
import com.example.gotogetherv3.R

class Search : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       val v = inflater.inflate(R.layout.search_frag, container, false)

        val edit = v.findViewById<EditText>(R.id.search_edit)
        val rec = v.findViewById<RecyclerView>(R.id.search_rec)

        var list : ArrayList<Event> = ArrayList()
        var photo_list: ArrayList<String> = ArrayList(); photo_list.add("https://sun1-85.userapi.com/c543107/v543107140/6683d/9N9bWIu5BnA.jpg")
        photo_list.add("https://sun1-85.userapi.com/c543107/v543107140/6683d/9N9bWIu5BnA.jpg")
        var interes : ArrayList<String> = arrayListOf("Театр и кино", "Юмор", "Игры и квесты", "Романтика и активный отдых")


        list.add(Event(0.toString(),"Вписка", "101", "12.12.12", "12:00", "100p", photo_list,interes))

        rec.layoutManager = LinearLayoutManager(v.context)
        var adapter  = Card_n(list)
        rec.adapter = adapter






        return v
    }



}