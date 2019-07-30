package com.example.gotogetherv3.Adapter

import android.content.Intent
import android.util.EventLog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gotogetherv3.Data.Event
import com.example.gotogetherv3.Full_card_activity
import com.example.gotogetherv3.R
import org.w3c.dom.Text

class User_profile (var list : ArrayList<Event>) : RecyclerView.Adapter<User_profile.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): User_profile.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.user_profile_item, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: User_profile.ViewHolder, position: Int) {
        holder.name.text = list[position].Name
        holder.date.text = list[position].Date
        holder.time.text = list[position].Time
        Glide.with(holder.itemView.context).load(list[position].Img[0]).into(holder.img)

        holder.icon.setOnClickListener {

        }


        holder.cont.setOnClickListener {
            val intent = Intent(holder.itemView.context, Full_card_activity::class.java)
            holder.itemView.context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){
        val name = itemView.findViewById<TextView>(R.id.user_profile_item_name)
        val date = itemView.findViewById<TextView>(R.id.user_profile_item_date)
        val time = itemView.findViewById<TextView>(R.id.user_profile_item_time)
        val icon = itemView.findViewById<ImageView>(R.id.user_profile_item_icon)
        val cont = itemView.findViewById<RelativeLayout>(R.id.user_profile_cont_main)
        val img = itemView.findViewById<ImageView>(R.id.user_profile_item_image)
    }
}