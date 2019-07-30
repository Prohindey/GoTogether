package com.example.gotogetherv3.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gotogetherv3.Data.Date_time
import com.example.gotogetherv3.R

class Date_and_time(val list: ArrayList<Date_time>): RecyclerView.Adapter<Date_and_time.ViewHolder>(){


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Date_and_time.ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.full_card_date_time_item, p0,false)




        return ViewHolder(v)
    }



    override fun onBindViewHolder(p0: Date_and_time.ViewHolder, p1: Int) {
        p0?.date.text = list[p1].date
        p0?.wdate.text = list[p1].week
        p0?.start.text = list[p1].start_t
        p0?.end.text = list[p1].end_t

    }

    override fun getItemCount(): Int {
        return list.size
    }


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val date = itemView.findViewById<TextView>(R.id.full_card_item_date)
        val wdate = itemView.findViewById<TextView>(R.id.full_card_item_wdate)
        val start = itemView.findViewById<TextView>(R.id.full_card_item_time_start)
        val end = itemView.findViewById<TextView>(R.id.full_card_item_time_end)
    }





}