package com.example.testrecyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.testrecyclerview.databinding.ActivityMainBinding
import kotlinx.coroutines.*



class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private var myAdapter: MyAdapter? = null
    private val viewModel by lazy {
        ViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        val recyclerView: RecyclerView = binding!!.myRecyclerView
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        myAdapter = MyAdapter { position -> viewModel.deleteElements(position)}
        recyclerView.adapter = myAdapter
        viewModel.initList()
        viewModel.addElementEvery5second()

        fun <T> MutableLiveData<T>.subscribe(action: (T) -> Unit) {
            observe(this@MainActivity) { it?.let { action(it) } }
        }

        viewModel.listChanges.subscribe {
            myAdapter!!.set(it)
        }
    }
}





