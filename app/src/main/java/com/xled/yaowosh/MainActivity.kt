package com.xled.yaowosh

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xled.yaowosh.ui.theme.YaowoshTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YaowoshTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Initialization(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun Initialization(modifier: Modifier = Modifier) {

    var is_loading by remember { mutableStateOf(false)}


    CoroutineScope(Dispatchers.IO).launch {
        delay(1000) // Для имитации загрузки
        is_loading = false
    }

    if (is_loading) {
        Box(
            modifier = Modifier.fillMaxSize()
        ){
            Image(painter = painterResource(R.drawable.yaowosh),
                contentDescription = "Yaowosh",
                modifier = Modifier.align(Alignment.Center))
        }
    } else {
        Column(modifier = modifier.fillMaxSize()) {
            TopBar()
            Slider()
            Categorys()
            Category()

        }
    }
}

@Composable
fun TopBar(){
    Box(
        modifier = Modifier.height(50.dp).fillMaxWidth()
    ){
        Text(
            text = "Your location? idk",
            fontSize = 15.sp,
            modifier = Modifier.align(Alignment.CenterStart).padding(start = 15.dp)
        )
        if (!isSystemInDarkTheme()){
            Image(
                painter = painterResource(R.drawable.basket),
                contentDescription = "Basket",
                modifier = Modifier.align(Alignment.CenterEnd).padding(end = 15.dp)
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

@Composable
fun Category(){

    val list_products = listOf(Product(
        0, "Banana", 4.8, 287, 3.99, R.drawable.banana),
        Product(1, "Pepper", 4.8, 287, 2.99, R.drawable.pepper),
        Product(2, "Orange", 4.9, 356, 4.99, R.drawable.orange)
        )


    Column (Modifier.fillMaxWidth()) {
        Box(Modifier.fillMaxWidth()){
            Text("Fruits", modifier = Modifier.padding(start = 10.dp).align(Alignment.CenterStart))

            Text("See all", modifier = Modifier.padding(end = 10.dp).align(Alignment.CenterEnd), color = Color(0xFF00FF00))
        }
        LazyRow {
            items(list_products, itemContent = { item ->
                CardProduct(item)
            })
        }
    }
}

@Composable
fun CardProduct(item: Product){
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
                    containerColor = color,
                ), CardDefaults.cardElevation(8.dp)
            ){
                Image(
                    painter = painterResource(item.image),
                    contentDescription = "Slide1",
                    modifier = Modifier
                        .graphicsLayer {
                            scaleX = 2.5f
                            scaleY = 2.5f
                        }
                        .padding(50.dp)
                )
            }
            Button(modifier = Modifier.align(Alignment.BottomEnd)
                .padding(10.dp)
                .height(50.dp)
                .width(50.dp), onClick = { addBasket(item) }) {
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

fun addBasket(item: Product) {

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    YaowoshTheme {
        //Category()
        Initialization()
    }
}