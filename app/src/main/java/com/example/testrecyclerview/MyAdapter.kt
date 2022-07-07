package com.example.testrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testrecyclerview.databinding.RecyclerviewItemBinding

class MyAdapter(private val onItemClicked: ((position: Int) -> Unit)) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var myList: List<Int> = listOf()

    fun set(newList: MutableList<Int>){
        myList = ArrayList(newList)
        notifyDataSetChanged()
    }

    class MyViewHolder(binding: RecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvNumber: TextView = binding.tvNumber
        val deleteButton = binding.deleteButton
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.apply {
            tvNumber.text = myList[position].toString()
            deleteButton.setOnClickListener { onItemClicked(position) }
        }
    }

    override fun getItemCount(): Int {
        return myList.size
    }
}


