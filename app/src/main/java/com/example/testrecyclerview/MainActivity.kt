package com.example.testrecyclerview

import MyAdapter
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.testrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private var myAdapter: MyAdapter? = null
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        val recyclerView: RecyclerView = binding!!.myRecyclerView
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        myAdapter = MyAdapter { position -> viewModel.deleteElements(position) }
        recyclerView.adapter = myAdapter
        viewModel.initList()
        viewModel.addElementEvery5second()
        viewModel.listChanges.observe(this) {
            myAdapter!!.set(it)
        }
    }
}


