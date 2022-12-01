package com.example.wsapptest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wsapptest.Global
import com.example.wsapptest.R
import com.example.wsapptest.model.classModel
import com.squareup.picasso.Picasso

class itemAdapter(private val itemList:ArrayList<classModel>):RecyclerView.Adapter<itemAdapter.classViwholder>() {
    class classViwholder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView =itemView.findViewById<ImageView>(R.id.imageView)
        val textView =itemView.findViewById<TextView>(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): classViwholder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return itemAdapter.classViwholder(itemView)
    }

    override fun onBindViewHolder(holder: classViwholder, position: Int) {
        val currentItem =itemList[position]
        //Picasso.get().load(currentItem.name).into(holder.imageView)
        holder.textView.text = currentItem.count
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}