package com.xled.yaowosh.data.models


import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class CartState(
    var list_cart: List<CartItem>
): Parcelable {

    companion object {
        val initValue = CartState(list_cart = listOf())
    }
}
