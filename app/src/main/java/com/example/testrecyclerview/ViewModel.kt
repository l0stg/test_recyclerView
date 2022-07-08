package com.example.testrecyclerview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class MainViewModel: ViewModel() {

    private val myData: DataModel = DataModel()

    private val _listChanges = MutableLiveData<List<Int>>()
    val listChanges: LiveData<List<Int>> = _listChanges

    private fun initList() {
        _listChanges.value = myData.fillList
    }

    fun deleteElements(position: Int){
        myData.fillList.removeAt(position)
        _listChanges.value = myData.fillList
    }

    private fun addElementEvery5second(){
        viewModelScope.launch {
            while (true) {
                delay(5000L)
                val randomPosition = (0..myData.fillList.size).random()
                val maxList = (myData.fillList.maxOrNull()?: 0) + 1
                myData.fillList.add(randomPosition, maxList)
                _listChanges.postValue(myData.fillList)
            }
        }
    }
    init {
        initList()
        addElementEvery5second()
    }

}
