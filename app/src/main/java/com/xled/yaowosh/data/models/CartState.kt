package com.xled.yaowosh.data.models


import android.os.Parcelable

data class CartState(
    var list_cart: List<CartItem>
) {

    companion object {
        val initValue = CartState(list_cart = listOf())
    }
}
