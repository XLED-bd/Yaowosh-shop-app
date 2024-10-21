package com.xled.yaowosh.ui.mainPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xled.yaowosh.R
import com.xled.yaowosh.data.models.Product

@Composable
fun Category(list_products: List<Product>, onAddToCartClick: (Product) -> Unit){
    Column (Modifier.fillMaxWidth()) {
        Box(Modifier.fillMaxWidth()){
            Text("Fruits", modifier = Modifier.padding(start = 10.dp).align(Alignment.CenterStart))

            Text("See all", modifier = Modifier.padding(end = 10.dp).align(Alignment.CenterEnd), color = Color(0xFF00FF00))
        }
        LazyRow {
            items(list_products, itemContent = { item ->
                CardProduct(item, onAddToCartClick = onAddToCartClick)
            })
        }
    }
}

@Composable
fun CardProduct(item: Product, onAddToCartClick: (Product) -> Unit){
    var color = Color(0xFFEEEEEE)
    if (isSystemInDarkTheme()){
        color = Color(0xFF555555)
    }

    Column {
        Box(modifier = Modifier.padding(10.dp)){
            Card(
                Modifier
                    .width(165.dp)
                    .height(165.dp)
                    .padding(8.dp),
                RoundedCornerShape(16.dp), CardDefaults.cardColors(
                    containerColor = color,), CardDefaults.cardElevation(8.dp)
            ){
                Image(
                    painter = painterResource(item.image),
                    contentDescription = "Slide1",
                    modifier = Modifier.graphicsLayer {
                        scaleX = 2.5f
                        scaleY = 2.5f
                    }.padding(50.dp)
                )
            }
            Button(modifier = Modifier.align(Alignment.BottomEnd)
                .padding(10.dp)
                .height(50.dp)
                .width(50.dp), onClick = { onAddToCartClick(item) }) {
                Text("+", fontSize = 30.sp)
            }
        }
        Text(text = item.name, fontSize = 20.sp, modifier = Modifier.padding(start = 20.dp))
        Row(modifier = Modifier.padding(start = 20.dp)) {

            Image(painter = painterResource(R.drawable.star),
                contentDescription = "star",
                modifier = Modifier.align(Alignment.CenterVertically).padding(end = 7.dp))

            Text("${item.rate} (${item.amount_rate})")
        }
        Text("$${item.cost}", fontSize = 20.sp, modifier = Modifier.padding(start = 20.dp, top = 5.dp))
    }

}