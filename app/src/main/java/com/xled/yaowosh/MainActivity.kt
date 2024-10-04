package com.xled.yaowosh

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.unit.fontscaling.MathUtils.lerp
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
fun calculateScale(listState: LazyListState, index: Int): Float {
    val firstVisibleItem = listState.firstVisibleItemIndex
    val firstVisibleOffset = listState.firstVisibleItemScrollOffset

    return if (firstVisibleItem == index) {
        lerp(0.85f, 1.05f, 1 - (firstVisibleOffset / 300f).coerceIn(0f, 1f))
    } else if (firstVisibleItem + 1 == index){
        lerp(1.05f, 0.85f, 1 - (firstVisibleOffset / 300f).coerceIn(0f, 1f))
    } else{
        0.85f
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    YaowoshTheme {
        Initialization()
    }
}