package com.example.wsapptest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wsapptest.R
import com.example.wsapptest.model.classModel

class itemAdapter(private val itemList:ArrayList<classModel>):RecyclerView.Adapter<itemAdapter.classViwholder>() {
    class classViwholder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView1 =itemView.findViewById<TextView>(R.id.textView1)
        val textView2 =itemView.findViewById<TextView>(R.id.textView2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): classViwholder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return itemAdapter.classViwholder(itemView)
    }

    override fun onBindViewHolder(holder: classViwholder, position: Int) {
        val currentItem =itemList[position]
        holder.textView1.text = currentItem.name
        holder.textView2.text = currentItem.count.toString()
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}