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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    YaowoshTheme {
        Initialization()
    }
}