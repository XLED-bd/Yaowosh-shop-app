package com.xled.yaowosh.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.xled.yaowosh.ui.cart.CartActivity
import com.xled.yaowosh.ui.cart.CartViewModel
import com.xled.yaowosh.ui.mainPage.MainPage
import com.xled.yaowosh.ui.mainPage.ProductViewModel
import com.xled.yaowosh.ui.theme.YaowoshTheme

class MainActivity : ComponentActivity() {

    private val catalogViewModel: ProductViewModel by viewModels()
    private val cartViewModel: CartViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {

            YaowoshTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainPage(
                        modifier = Modifier.padding(innerPadding),
                        catalogViewModel,
                        cartViewModel,
                    ){
                        val context = this
                        val intent = Intent(context, CartActivity::class.java)
                        //val bundle = Bundle()
                        //bundle.putParcelable("cartViewModel", cartViewModel.cart.value)
                        intent.putExtra("CartState", cartViewModel.cart.value)
                        context.startActivity(intent)
                    }
                }
            }
        }
    }
}