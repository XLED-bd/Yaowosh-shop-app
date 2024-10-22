package com.xled.yaowosh.data.models

data class CartState(
    var list_cart: List<CartItem>
) {

    companion object {
        val initValue = CartState(list_cart = listOf())
    }
}
