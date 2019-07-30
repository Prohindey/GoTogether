package com.example.gotogetherv3.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gotogetherv3.Data.Chat
import com.example.gotogetherv3.Full_card_activity
import com.example.gotogetherv3.Full_chat
import com.example.gotogetherv3.R

class Chats (val list :ArrayList<Chat>) : RecyclerView.Adapter<Chats.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Chats.ViewHolder {
       val v = LayoutInflater.from(parent.context).inflate(R.layout.chats_item, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: Chats.ViewHolder, position: Int) {
        
        holder.name.text = list[position].Name
        holder.mes.text = list[position].Mess
        Glide.with(holder.itemView).load(list[position].Photo).into(holder.photo)

        holder.cont.setOnClickListener {
            val intent = Intent(holder.itemView.context, Full_chat::class.java)
            intent.putExtra("Name", list[position].Name)
            intent.putExtra("Img", list[position].Photo)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
       val name = itemView.findViewById<TextView>(R.id.chats_name)
       val mes = itemView.findViewById<TextView>(R.id.chats_mes)
       val photo = itemView.findViewById<ImageView>(R.id.chats_photo)
       val cont =  itemView.findViewById<RelativeLayout>(R.id.chat_cont)
    }

}