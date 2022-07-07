package com.example.testrecyclerview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class ViewModel: ViewModel() {

    private val fillList: MutableList<Int> = mutableListOf(1,2,3,4,5,6,7,8)

    var listChanges: MutableLiveData<MutableList<Int>> = MutableLiveData()

    fun initList() {
        listChanges.value = fillList
    }

    fun deleteElements(position: Int){
        fillList.removeAt(position)
        listChanges.value = fillList
    }

    fun addElementEvery5second(){
        CoroutineScope(Dispatchers.IO).launch {
            while (true) {
                delay(5000L)
                val randomPosition = (0..fillList.size).random()
                val maxList = (fillList.maxOrNull()?: 0) + 1
                fillList.add(randomPosition, maxList)
                listChanges.postValue(fillList)
            }
        }
    }
}


