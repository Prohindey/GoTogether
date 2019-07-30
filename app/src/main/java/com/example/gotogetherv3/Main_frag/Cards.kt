package com.example.gotogetherv3.Main_frag

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.gotogetherv3.Adapter.Card_n
import com.example.gotogetherv3.Data.Event
import com.example.gotogetherv3.R
import com.example.gotogetherv3.Registration.Registr_frag.Information
import org.json.JSONObject

class Cards: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.cards_frag, container, false)

        val rec = v.findViewById<RecyclerView>(R.id.cards_rec)
        var list : ArrayList<Event> = ArrayList()
        var interes : ArrayList<String> = ArrayList()



        var sharPer : SharedPreferences = v.context.getSharedPreferences("User_data", Context.MODE_PRIVATE)
        val data_email = sharPer.getString("mail","")
        val data_pas = sharPer.getString("pass", "")

        val url = "http://84.201.167.48:3000/api/v1/login"


        val jsonobj = JSONObject()
        jsonobj.put("email",data_email)
        jsonobj.put("password", data_pas)

        val que = Volley.newRequestQueue(v.context)
        val req = object: JsonObjectRequest(
            Method.POST, url, jsonobj,
            com.android.volley.Response.Listener<JSONObject>{
                    response ->

                    var events = response.getJSONObject("events")
//                    for (i in 0..events.length()-1){


                        events.keys().forEach{
                            interes.clear()
                            var ev = events.getJSONObject(it)
                            var title = ev.getString("title")
                            var photo_list: ArrayList<String> = arrayListOf(ev.getJSONArray("photo_links").getString(0))
                            var inte = ev.getJSONArray("categories")
                            for (k in 0..inte.length()-1){
                                interes.add(inte.getString(k))
                            }
                            var price = ev.getString("price")
                            list.add(Event(it.toString(),title,"5","12.12.12","00:00",price,photo_list,interes))

                        }


            },com.android.volley.Response.ErrorListener{
                    error ->
                Log.d("Error_response", error.toString())
            })

        {

        }
        que.add(req)




        var photo_list: ArrayList<String> = ArrayList(); photo_list.add("https://wegotthiscovered.com/wp-content/uploads/2018/01/harry-potter-ar-game.jpg")
//        photo_list.add("https://sun1-85.userapi.com/c543107/v543107140/6683d/9N9bWIu5BnA.jpg")
//
//        var interes : ArrayList<String> = arrayListOf("Театр и кино", "Юмор", "Игры и квесты", "Романтика и активный отдых")
//
//        //TODO: Заполнить массив
        list.add(Event(0.toString(),"Вписка", "101", "12.12.12", "12:00", "100p", photo_list, interes))
//        list.add(Event(0.toString(),"Вписка", "101", "12.12.12", "12:00", "100p", photo_list, interes))
//        list.add(Event(0.toString(),"Вписка", "101", "12.12.12", "12:00", "100p", photo_list, interes))
//        list.add(Event(0.toString(),"Вписка", "101", "12.12.12", "12:00", "100p", photo_list, interes))




        rec.layoutManager = LinearLayoutManager(v.context)
        var adapter  = Card_n(list)
        rec.adapter = adapter



        return v
    }
}