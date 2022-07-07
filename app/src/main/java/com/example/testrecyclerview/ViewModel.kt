package com.example.testrecyclerview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class ViewModel: ViewModel() {
    private val myData: DataModel = DataModel()

    var positionLiveData: MutableLiveData<Int> = MutableLiveData()

    var newElementAdd: MutableLiveData<MutableList<Int>> = MutableLiveData()

    fun deleteElements(position: Int){
        positionLiveData.value = position
        DataModel().fillList.removeAt(position)
    }
    fun addElementEvery5second() {
        CoroutineScope(Dispatchers.Main).launch {
            while (true) {
                withContext(Dispatchers.IO) {
                    delay(5000L)
                    val maxFillList = myData.fillList.maxOrNull()?.plus(1)
                    val randomPosition = (0..DataModel().fillList.size).random()
                    myData.fillList.add(randomPosition, maxFillList!!)
                    newElementAdd.postValue(myData.fillList)
                }
            }
        }
    }
}

