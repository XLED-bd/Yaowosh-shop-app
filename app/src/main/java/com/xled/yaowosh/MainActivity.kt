package com.xled.yaowosh

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
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

    var is_loading by remember { mutableStateOf(true)}

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
        Column( modifier = modifier) {



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