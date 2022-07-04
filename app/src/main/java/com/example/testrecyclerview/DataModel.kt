package com.example.testrecyclerview

import kotlinx.coroutines.*

var randomPosition: Int? = null
var fillList = mutableListOf(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)

class DataModel {
    private fun addElement() {
        randomPosition = (0..fillList.size).random()
        val maxFillList = fillList.maxOrNull() ?: 0
        fillList.add(randomPosition!!, maxFillList + 1)
    }

    //корутина которая каждые 5 секунд добавляет элемент
    fun addElementEvery5second() {
        GlobalScope.launch(Dispatchers.Main) {
            while (true) {
                withContext(Dispatchers.Default) {
                    delay(5000L)
                    DataModel().addElement()
                }
                MainActivity().updateData()
            }
        }
    }
}
