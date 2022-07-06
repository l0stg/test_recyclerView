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

    fun addElementEvery5second() {
        CoroutineScope(Dispatchers.Main).launch {
            while (true) {
                withContext(Dispatchers.IO) {
                    delay(5000L)
                }
                val maxFillList = DataModel().fillList.maxOrNull() ?: (0 + 1)
                newElementAdd.value = maxFillList
            }
        }
    }

}

