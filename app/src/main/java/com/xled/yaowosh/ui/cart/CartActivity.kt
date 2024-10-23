package com.xled.yaowosh.ui.cart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.xled.yaowosh.data.models.CartState
import com.xled.yaowosh.ui.theme.YaowoshTheme

class CartActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val list_cart = intent.getParcelableExtra<CartState>("CartState")

        setContent {
            YaowoshTheme {
                LazyColumn {
                    items(list_cart!!.list_cart){ item ->
                        Text(item.toString())
                    }

                }

            }
        }

    }
}