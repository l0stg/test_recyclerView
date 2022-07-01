package com.example.testrecyclerview

var randomPosition: Int? = null
var fillList = mutableListOf(0,1,2,3,4,5)

class DataModel {

    fun addElement () {
        randomPosition = (0..fillList.size).random()
        val maxFillList = fillList.maxOrNull() ?: 0
        fillList.add(randomPosition!!, maxFillList + 1)
    }
}
