package com.example.testrecyclerview

import kotlinx.coroutines.*

class DataModel {

    val fillList = mutableListOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
    private var fillListCopy = mutableListOf<Int>()// Сделать этот лист наблюдаемым и когда он меняется вызывать refreshDataRV

    /*private fun addElement() {
        fillListCopy = myAdapter.myList.toMutableList()
        val randomPosition = (0..fillListCopy.size).random()
        val maxFillList = fillListCopy.maxOrNull() ?: 0
        fillListCopy.add(randomPosition, maxFillList + 1)
    }*/


    //корутина которая каждые 5 секунд добавляет элемент


}

