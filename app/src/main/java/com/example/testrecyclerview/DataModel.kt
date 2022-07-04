package com.example.testrecyclerview

import kotlinx.coroutines.*

var fillList = mutableListOf(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)
var fillListCopyAdd = mutableListOf<Int>()

class DataModel {

    //Добавление элементов, надо уйти от обьявления переменной вне корутины!
    private fun addElement() {
        fillListCopyAdd = myAdapter.myList.toMutableList()
        val randomPosition = (0..fillListCopyAdd.size).random()
        val maxFillList = fillListCopyAdd.maxOrNull() ?: 0
        fillListCopyAdd.add(randomPosition, maxFillList + 1)
    }

    //корутина которая каждые 5 секунд добавляет элемент
    fun addElementEvery5second() {
        CoroutineScope(Dispatchers.Main).launch {
            while (true) {
                withContext(Dispatchers.IO) {
                    delay(5000L)
                    addElement()
                }
                //костыль, надо сделать Observer, тогда будет правильно
                myAdapter.refreshDataRV(fillListCopyAdd)
            }
        }
    }
}


