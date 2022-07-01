package com.example.testrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testrecyclerview.databinding.RecyclerviewItemBinding

class MyAdapter(): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private fun updateData() {
        val randomPos = randomPosition
        notifyItemInserted(randomPos!!)
        notifyItemRangeChanged(randomPos, itemCount)
        println("Функция вызвана")
    }

    class MyViewHolder(binding: RecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
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
            DataModel().addElement()
            updateData()
        }
    }

    override fun getItemCount(): Int {
        return fillList.size
    }
}


