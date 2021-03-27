package com.uzair.shoemate.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uzair.shoemate.data_source.Shoe

class ActivityViewModel : ViewModel() {
    private val shoeInventory = LinkedHashSet<Shoe>()
    private val _shoes = MutableLiveData<Set<Shoe>>()
    val shoes: LiveData<Set<Shoe>> = _shoes

    fun addShoeToInventory(shoe: Shoe) {
        shoeInventory.add(shoe)
        _shoes.postValue(shoeInventory)
    }
}