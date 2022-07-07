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

class MyAdapter(var myList: MutableList<Int>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    //функция DiffUtil для обновления данных
    fun changesRV(fillListCopy: MutableList<Int>){
        val diffCallback = DataDiffCallback(myList, fillListCopy)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        myList = fillListCopy.toMutableList()
        diffResult.dispatchUpdatesTo(this)
    }

    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClickDeleteButton(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        mListener = listener
    }

    class MyViewHolder(binding: RecyclerviewItemBinding, listener: OnItemClickListener) : RecyclerView.ViewHolder(binding.root) {
        val tvNumber: TextView = binding.tvNumber
        init {
            binding.deleteButton.setOnClickListener {
                listener.onItemClickDeleteButton(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvNumber.text = myList[position].toString()
    }

    override fun getItemCount(): Int {
        return myList.size
    }
}


