package com.example.gotogetherv3.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gotogetherv3.R


class Full_card_photo(val list: ArrayList<String>) : RecyclerView.Adapter<Full_card_photo.ViewHolder>(){


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Full_card_photo.ViewHolder {
       val v = LayoutInflater.from(p0.context).inflate(R.layout.full_card_photo_item, p0, false)


        return ViewHolder(v)
    }

    override fun onBindViewHolder(p0: Full_card_photo.ViewHolder, p1: Int) {
        Glide.with(p0.itemView).load(list[p1]).into(p0?.img)
    }


    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemVIew: View) : RecyclerView.ViewHolder(itemVIew){
        val img = itemView.findViewById<ImageView>(R.id.full_card_item_photo)
    }




}