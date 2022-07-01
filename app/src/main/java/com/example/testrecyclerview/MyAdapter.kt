package com.example.testrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testrecyclerview.databinding.ActivityMainBinding
import com.example.testrecyclerview.databinding.RecyclerviewItemBinding


class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    fun  getData(){
        DataModel().addElement()
        notifyDataSetChanged()
        println("Функция вызвана")
    }

    class MyViewHolder(private val binding: RecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvNumber: TextView = binding.tvNumber
        val deleteButton: Button = binding.deleteButton
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvNumber.text = fillList[position].toString()
        holder.deleteButton.setOnClickListener {
            fillList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, itemCount)
        }
        holder.itemView.setOnClickListener{
            getData()
        }

    }

    override fun getItemCount(): Int {
        return fillList.size
    }
}


