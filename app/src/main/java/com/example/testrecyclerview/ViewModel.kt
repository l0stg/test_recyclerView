package com.example.testrecyclerview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class ViewModel: ViewModel() {

    var positionLiveData: MutableLiveData<Int> = MutableLiveData()

    var newElementAdd: MutableLiveData<Int> = MutableLiveData()

    fun deleteElements(position: Int){
        positionLiveData.value = position
    }

    fun addElementEvery5second(){
        CoroutineScope(Dispatchers.IO).launch {
            while (true) {
                delay(5000L)
                newElementAdd.postValue(1)
            }
        }
    }
}


