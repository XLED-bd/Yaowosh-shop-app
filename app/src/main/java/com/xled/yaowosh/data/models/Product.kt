package com.xled.yaowosh.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: Int,
    val name: String,
    val rate: Double,
    val amount_rate: Int,
    val cost: Double,
    val image: Int
    ): Parcelable {
}

@Parcelize
data class CartItem(val product: Product, val quantity: Int): Parcelable