package com.example.testrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
        myAdapter= MyAdapter(fillList)
        recyclerView.adapter = myAdapter

        GlobalScope.launch(Dispatchers.Main) {
            while (true) {
                withContext(Dispatchers.Default) {
                    delay(5000L)
                    DataModel().addElement()
                }
                updateData()
            }
        }
    }

    private fun updateData() {
        val randomPos = randomPosition
        myAdapter.notifyItemInserted(randomPos!!)
        myAdapter.notifyItemRangeChanged(randomPos, myAdapter.itemCount)
        println("Функция вызвана")
    }

}




