package com.example.testrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter():
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNumber: TextView = itemView.findViewById(R.id.tvNumber)
        val deleteButton: Button = itemView.findViewById(R.id.deleteButton)
    }

    fun addElement(){
        fillList.add(fillList.last() + 1)
       // notifyItemInserted(fillList.last())
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvNumber.text = fillList[position].toString()
        holder.deleteButton.setOnClickListener {
            fillList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,getItemCount())
        }
        /*holder.itemView.setOnClickListener{
            addElement()
        }*/
    }

    override fun getItemCount(): Int {
        return fillList.size
    }
}


