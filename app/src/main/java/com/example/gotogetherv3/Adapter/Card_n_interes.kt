package com.example.gotogetherv3.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gotogetherv3.R
import kotlinx.android.synthetic.main.card_n_interes_item.view.*

class Card_n_interes (var list: ArrayList<String>) : RecyclerView.Adapter<Card_n_interes.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Card_n_interes.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_n_interes_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: Card_n_interes.ViewHolder, position: Int) {
        holder.title.text = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var title = itemView.findViewById<TextView>(R.id.card_n_interes_text)
    }

}