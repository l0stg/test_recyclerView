package com.example.testrecyclerview

import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


var fillList = mutableListOf(9,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)

class DataModel() {

    fun addElement(){
        fillList.add((1..fillList.size).random(),fillList.last() + 1)
    }
}
//al fillList1 = MutableLiveData<List<Int>>()
//fun addUser() {
    /*val newList = mutableListOf<Int>()
    newList.add(1)
    newList.add(2)
    newList.add(3)
    newList.add(4)
    fillList.postValue(newList)
}*/


