package com.example.testrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.testrecyclerview.databinding.RecyclerviewItemBinding

class DataDiffCallback(
    private var oldList: MutableList<Int>,
    private var newList: MutableList<Int>
): DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldElement = oldList[oldItemPosition]
        val newElement = newList[newItemPosition]
        return oldElement == newElement
    }
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldElement = oldList[oldItemPosition]
        val newElement = newList[newItemPosition]
        return oldElement == newElement
    }
}

class MyAdapter(private val onItemClicked: ((position: Int) -> Unit)) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    var myList: MutableList<Int> = mutableListOf()

    fun addElementsFirst(){
        myList = DataModel().fillList
        notifyDataSetChanged()
    }
    fun changesRV(fillListCopy: MutableList<Int>){
        val diffCallback = DataDiffCallback(myList, fillListCopy)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        myList = fillListCopy.toMutableList()
        diffResult.dispatchUpdatesTo(this)
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
        holder.tvNumber.text = myList[position].toString()
        holder.deleteButton.setOnClickListener { onItemClicked(position) }

    }

    override fun getItemCount(): Int {
        return myList.size
    }

    fun deleteItem(position: Int){
        myList.removeAt(position)
        this.notifyDataSetChanged()
    }

    fun newElementAdd(newElement: Int){
        val randomPosition = (0..myList.size).random()
        myList.add(randomPosition, newElement)
        notifyDataSetChanged()
    }
}


