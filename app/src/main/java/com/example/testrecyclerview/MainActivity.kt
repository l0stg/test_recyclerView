package com.example.testrecyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.testrecyclerview.databinding.ActivityMainBinding
import kotlinx.coroutines.*

lateinit var binding: ActivityMainBinding
lateinit var myAdapter: MyAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerView: RecyclerView = binding.myRecyclerView
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        myAdapter = MyAdapter(DataModel().fillList)
        recyclerView.adapter = myAdapter
        val myDataModel = DataModel()
        myDataModel.addElementEvery5second()

        //Обработка нажатия кнопки DELETE
        myAdapter.setOnItemClickListener(object : MyAdapter.OnItemClickListener {
            override fun onItemClickDeleteButton(position: Int) {
                myDataModel.deleteElement(position)
            }
        })
    }
}




