package com.example.testrecyclerview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class ViewModel: ViewModel() {

    private val myData: DataModel = DataModel()

    var listChanges: MutableLiveData<MutableList<Int>> = MutableLiveData()

    fun initList() {
        listChanges.value = myData.fillList
    }

    fun deleteElements(position: Int){
        myData.fillList.removeAt(position)
        listChanges.value = myData.fillList
    }

    fun addElementEvery5second(){
        CoroutineScope(Dispatchers.IO).launch {
            while (true) {
                delay(5000L)
                val randomPosition = (0..myData.fillList.size).random()
                val maxList = (myData.fillList.maxOrNull()?: 0) + 1
                myData.fillList.add(randomPosition, maxList)
                listChanges.postValue(myData.fillList)
            }
        }
    }
}


