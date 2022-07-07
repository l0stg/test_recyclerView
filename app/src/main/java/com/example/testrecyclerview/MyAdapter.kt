package com.example.testrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.testrecyclerview.databinding.RecyclerviewItemBinding

class UsersDiffCallback(
    private val oldList: List<Int>,
    private val newList: List<Int>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size
    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldUser = oldList[oldItemPosition]
        val newUser = newList[newItemPosition]
        return oldUser == newUser
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldUser = oldList[oldItemPosition]
        val newUser = newList[newItemPosition]
        return oldUser == newUser
    }
}

class MyAdapter(private val onItemClicked: ((position: Int) -> Unit)) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var myList: List<Int> = listOf()

    fun set(newList: MutableList<Int>){
        val diffCallback = UsersDiffCallback(myList, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        myList = ArrayList(newList)
        diffResult.dispatchUpdatesTo(this)
        notifyItemRangeChanged(0, itemCount)
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


