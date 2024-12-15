package com.xled.yaowosh.data.models

import android.os.Parcelable

data class Product(
    val id: Int,
    val name: String,
    val rate: Double,
    val amount_rate: Int,
    val cost: Double,
    val image: Int
    ) {
}


data class CartItem(val product: Product, val quantity: Int)