package com.xled.yaowosh.ui.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.util.copy
import com.xled.yaowosh.data.models.CartItem
import com.xled.yaowosh.data.models.CartState
import com.xled.yaowosh.data.models.Product
import com.xled.yaowosh.ui.mainPage.MainViewEvent
import com.xled.yaowosh.ui.mainPage.OnClickAddCartEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class CartViewModel: ViewModel() {
    private var _cart = MutableStateFlow(CartState.initValue)
    val cart: StateFlow<CartState> = _cart.asStateFlow()

    private suspend fun addItem(product: Product){
        _cart.value = _cart.value.copy(
            list_cart = _cart.value.list_cart + CartItem(product, 1)
        )
    }

    fun onEvent(product: Product, event: MainViewEvent) {
        viewModelScope.launch {
            when (event) {
                is OnClickAddCartEvent -> addItem(product)
            }
        }
    }

}

