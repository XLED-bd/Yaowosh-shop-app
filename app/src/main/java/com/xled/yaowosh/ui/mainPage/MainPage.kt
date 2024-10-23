package com.xled.yaowosh.ui.mainPage

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xled.yaowosh.R
import com.xled.yaowosh.data.models.CartItem
import com.xled.yaowosh.data.models.CartState
import com.xled.yaowosh.data.models.Product
import com.xled.yaowosh.logic.calculateScale
import com.xled.yaowosh.ui.cart.CartActivity
import com.xled.yaowosh.ui.cart.CartViewModel
import com.xled.yaowosh.ui.cart.MiniIconItemCart
import com.xled.yaowosh.ui.theme.YaowoshTheme


@Composable
fun MainPage(
    modifier: Modifier = Modifier,
    catalogViewModel: ProductViewModel,
    cartViewModel: CartViewModel,
    onOpenCartClick: () -> Unit
) {
    val list_product by catalogViewModel.product.observeAsState(emptyList())
    val cart_state by cartViewModel.cart.collectAsState()


    Box{
        Column(modifier = modifier.fillMaxSize()) {
            TopBar(onOpenCartClick)
            Slider()
            Categorys()
            Category(list_product) { selectedItem ->
                cartViewModel.onEvent(selectedItem, OnClickAddCartEvent)
                Log.d("!!!!", cart_state.list_cart.toString())
            }
        }

        if (cart_state.list_cart.isNotEmpty()) {
            Card(modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(20.dp),
                RoundedCornerShape(50.dp),
                CardDefaults.cardColors(
                    containerColor = Color.Green,
                ), CardDefaults.cardElevation(8.dp),
            ) {
                Row {
                    Box(modifier = Modifier.align(Alignment.CenterVertically)) {
                        if (!isSystemInDarkTheme()){
                            Image(
                                painter = painterResource(R.drawable.basket),
                                contentDescription = "Basket",
                                modifier = Modifier.align(Alignment.CenterEnd).padding(10.dp)
                            )
                        } else {
                            Image(
                                painter = painterResource(R.drawable.basket_black_theme),
                                contentDescription = "Basket",
                                modifier = Modifier.align(Alignment.CenterEnd)
                            )
                        }
                    }

                    LazyRow ( Modifier.align(Alignment.CenterVertically)) {
                        items(cart_state.list_cart) { item ->
                            MiniIconItemCart(item)
                        }
                    }
                }
            }
            }
        }
}

@Composable
fun TopBar(onOpenCartClick: () -> Unit){
    var color = Color(0xFFEEEEEE)
    if (isSystemInDarkTheme()){
        color = Color(0xFF555555)
    }
    Box(
        modifier = Modifier.height(50.dp).fillMaxWidth()
    ){
        Text(
            text = "Your location? idk",
            fontSize = 15.sp,
            modifier = Modifier.align(Alignment.CenterStart).padding(start = 15.dp)
        )

        Button(modifier = Modifier.align(Alignment.CenterEnd).padding(end = 5.dp).width(40.dp),
            colors = ButtonColors(color, color, color, color),
            onClick = { onOpenCartClick() }) {
        }
        if (!isSystemInDarkTheme()){
            Image(
                painter = painterResource(R.drawable.basket),
                contentDescription = "Basket",
                modifier = Modifier.align(Alignment.CenterEnd).padding(end = 15.dp),
            )
        } else {
            Image(
                painter = painterResource(R.drawable.basket_black_theme),
                contentDescription = "Basket",
                modifier = Modifier.align(Alignment.CenterEnd).padding(end = 15.dp)
            )
        }

    }
}


@Composable
fun Slider(){
    val listState = rememberLazyListState()

    LazyRow(
        state = listState,
        modifier = Modifier.fillMaxWidth()
    ) {
        item {
            val scale = calculateScale(listState, 0)
            Card(
                Modifier
                    .width(343.dp)
                    .height(182.dp)
                    .padding(8.dp)
                    .graphicsLayer {
                        scaleX = scale
                        scaleY = scale
                    }, RoundedCornerShape(16.dp), CardDefaults.cardColors(
                    containerColor = Color(0xFFD7FFD4),
                ), CardDefaults.cardElevation(8.dp)
            ) {
                Box{
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Title 1",
                            color = Color(0xFF000000)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "descp1",
                            color = Color(0xFF000000)
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        Button(onClick = { }) {
                            Text("Order")
                        }
                    }

                    Image(
                        painter = painterResource(R.drawable.slide1),
                        contentDescription = "Slide1",
                        modifier = Modifier.align(Alignment.CenterEnd)
                            .graphicsLayer {
                                scaleX = 2f
                                scaleY = 2f
                            }
                            .padding(end = 15.dp)
                    )
                }
            }
        }

        item { val scale = calculateScale(listState, 1)
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF0CA201),
                ),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(8.dp),
                modifier = Modifier
                    .width(343.dp)
                    .height(182.dp)
                    .padding(8.dp)
                    .graphicsLayer {
                        scaleX = scale
                        scaleY = scale
                    }
            ) {
                Box{
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Title 2",
                            color = Color(0xFF000000)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "descp2",
                            color = Color(0xFF000000)
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        Button(onClick = { }) {
                            Text("Order")
                        }
                    }

                    Image(
                        painter = painterResource(R.drawable.slide2),
                        contentDescription = "Slide2",
                        modifier = Modifier.align(Alignment.CenterEnd)
                            .graphicsLayer {
                                scaleX = 2f
                                scaleY = 2f
                            }
                            .padding(end = 15.dp)
                    )
                }
            }
        }

        item { val scale = calculateScale(listState, 2)
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFFFDB24),
                ),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(8.dp),
                modifier = Modifier
                    .width(343.dp)
                    .height(182.dp)
                    .padding(8.dp)
                    .graphicsLayer {
                        scaleX = scale
                        scaleY = scale
                    }
            ) {
                Box{
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Title 3",
                            color = Color(0xFF000000)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "descp3",
                            color = Color(0xFF000000)
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        Button(onClick = { }) {
                            Text("Order")
                        }
                    }

                    Image(
                        painter = painterResource(R.drawable.slide3),
                        contentDescription = "Slide3",
                        modifier = Modifier.align(Alignment.CenterEnd)
                            .graphicsLayer {
                                scaleX = 2f
                                scaleY = 2f
                            }
                            .padding(end = 15.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun Categorys(){
    var color = Color(0xFFEEEEEE)
    if (isSystemInDarkTheme()){
        color = Color(0xFF555555)
    }


    LazyRow(
        modifier = Modifier.fillMaxWidth()
            .padding(top = 15.dp)
    ){
        item {
            Column {
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
                        painter = painterResource(R.drawable.category_fruits),
                        contentDescription = "category_fruits",
                        modifier = Modifier.padding(10.dp)
                            .height(70.dp)
                            .width(70.dp)
                    )

                }
                Text(text = "fruits",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontSize = 12.sp
                )

            }
        }

        item {
            Column {
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
                        painter = painterResource(R.drawable.category_milk),
                        contentDescription = "category_milk",
                        modifier = Modifier.padding(10.dp)
                            .height(70.dp)
                            .width(70.dp)
                    )

                }
                Text(text = "milk",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontSize = 12.sp
                )
            }
        }

        item {
            Column {
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
                        painter = painterResource(R.drawable.category_laudry),
                        contentDescription = "category_laudry",
                        modifier = Modifier.padding(10.dp)
                            .height(70.dp)
                            .width(70.dp)
                    )

                }
                Text(text = "laudry",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontSize = 12.sp
                )
            }
        }

        item {
            Column {
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
                        painter = painterResource(R.drawable.category_beverages),
                        contentDescription = "category_beverages",
                        modifier = Modifier.padding(10.dp)
                            .height(70.dp)
                            .width(70.dp)
                    )

                }
                Text(text = "beverages",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontSize = 12.sp
                )
            }
        }

        item {
            Column {
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
                        painter = painterResource(R.drawable.category_vegetable),
                        contentDescription = "category_vegetable",
                        modifier = Modifier.padding(10.dp)
                            .height(70.dp)
                            .width(70.dp)
                    )

                }
                Text(text = "vegetable",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontSize = 12.sp
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val catalogViewModel = ProductViewModel()
    val cartViewModel = CartViewModel()

    cartViewModel.setCart(CartState(list_cart = listOf(
        CartItem(
            Product(0, "Banana", 4.8, 287, 3.99, R.drawable.banana), 1),
        CartItem(
            Product(1, "Pepper", 4.8, 287, 2.99, R.drawable.pepper),6 )
            )
        )
    )

    YaowoshTheme {
        MainPage(modifier = Modifier.fillMaxSize(), catalogViewModel, cartViewModel){}
    }
}