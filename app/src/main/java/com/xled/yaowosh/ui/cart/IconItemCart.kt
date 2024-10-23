package com.xled.yaowosh.ui.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.xled.yaowosh.data.models.CartItem

@Composable
fun MiniIconItemCart(cartItem: CartItem){
    var color = Color(0xFFEEEEEE)
    if (isSystemInDarkTheme()){
        color = Color(0xFF555555)
    }

    Card(
        Modifier
            .width(80.dp)
            .height(80.dp)
            .padding(5.dp),
        RoundedCornerShape(50.dp), CardDefaults.cardColors(
            containerColor = color,
        ), CardDefaults.cardElevation(8.dp)
    ){
        Image(
            painter = painterResource(cartItem.product.image),
            contentDescription = "cart_image",
            modifier = Modifier.padding(10.dp)
                .height(70.dp)
                .width(70.dp)
        )

    }
}