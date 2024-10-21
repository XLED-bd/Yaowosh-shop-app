package com.xled.yaowosh.ui.cart

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xled.yaowosh.data.models.CartItem
import com.xled.yaowosh.data.models.Product

class CartViewModel: ViewModel() {
    private val _cart = MutableLiveData(emptyList<CartItem>().toMutableList())
    val cart: LiveData<MutableList<CartItem>> = _cart

    fun addItem(product: Product){
        _cart.value?.add(CartItem(product, 1))
    }

}