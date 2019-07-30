package com.example.gotogetherv3.Adapter

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gotogetherv3.Data.Event
import com.example.gotogetherv3.Full_card_activity
import com.example.gotogetherv3.R

class Card_n (var list : ArrayList<Event>) : RecyclerView.Adapter<Card_n.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Card_n.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_item_new, parent, false)
        return ViewHolder(v)//To change body of created functions use File | Settings | File Templates.
    }


    override fun onBindViewHolder(holder: Card_n.ViewHolder, position: Int) {


        if (list[position].Name.length < 40){
            holder.name.textSize = 24.0f
            holder.name.text = list[position].Name
        }
        if (list[position].Name.length > 40 && list[position].Name.length < 100){
            holder.name.textSize = 19.0f
            holder.name.text = list[position].Name
        }
        if (list[position].Name.length > 100 && list[position].Name.length < 150){
            holder.name.textSize = 15.0f
            holder.name.text = list[position].Name
        }


        holder.like.text = list[position].Like

        Glide.with(holder.itemView).load(list[position].Img[0]).into(holder?.photo)

        holder.rec.layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
        val adapter = Card_n_interes(list[position].Interes)
        holder.rec.adapter = adapter

        holder.cont.setOnClickListener {
            val intent = Intent(holder.itemView.context, Full_card_activity::class.java)

            var pair1 = Pair<View,String>(holder.name, "nameTransition")
            var pair2 = Pair<View,String>(holder.photo,"imageTransition")
            var pair3 = Pair<View,String>(holder.name_cont, "cardTransition")


            intent.putExtra("ID", list[position].ID)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val name = itemView.findViewById<TextView>(R.id.card_n_name)
        val like = itemView.findViewById<TextView>(R.id.card_n_text_like)

        val photo = itemView.findViewById<ImageView>(R.id.card_n_photo)

        val rec = itemView.findViewById<RecyclerView>(R.id.card_n_rec)

        val cont = itemView.findViewById<CardView>(R.id.card_n_cont)

        val name_cont = itemView.findViewById<CardView>(R.id.card_item_name_cont)

    }
}