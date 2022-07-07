package com.example.testrecyclerview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class MainViewModel: ViewModel() {

    private val myData: DataModel = DataModel()

    private val _listChanges = MutableLiveData<List<Int>>()
    val listChanges: LiveData<List<Int>> = _listChanges

    fun initList() {
        _listChanges.value = myData.fillList
    }

    fun deleteElements(position: Int){
        myData.fillList.removeAt(position)
        _listChanges.value = myData.fillList
    }

    fun addElementEvery5second(){
        CoroutineScope(Dispatchers.IO).launch {
            while (true) {
                delay(5000L)
                val randomPosition = (0..myData.fillList.size).random()
                val maxList = (myData.fillList.maxOrNull()?: 0) + 1
                myData.fillList.add(randomPosition, maxList)
                _listChanges.postValue(myData.fillList)
            }
        }
    }

}
