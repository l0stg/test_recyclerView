package com.example.testrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testrecyclerview.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //var fillList1 = MutableLiveData<MutableList<Int>>()
        //fillList = fillList1
        val recyclerView: RecyclerView = binding.myRecyclerView
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = MyAdapter()

         /*GlobalScope.launch {
            while (true) {
                delay(5000L)
                DataModel().addElement()
                println(fillList)
                MyAdapter().getData()
            }
        }*/

        /* fun getLastElement(): Flow<Int> = flow {
                    val database = fillList  // условная база данных

                    while (true) {
                        delay(5000L) // имитация продолжительной работы
                        println(database.add(database.last()+1))
                        emit(database.last()) //
                    }
                }
               /* suspend fun main(){
                    val lastElement = getLastElement()
                    lastElement.collect{
                        fillList.add(lastElement)
                    }
                }*/
                */

    }
}


