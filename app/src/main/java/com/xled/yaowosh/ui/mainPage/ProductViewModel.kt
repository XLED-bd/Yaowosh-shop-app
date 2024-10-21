package com.xled.yaowosh.ui.mainPage

import android.annotation.SuppressLint
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xled.yaowosh.R
import com.xled.yaowosh.data.models.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@SuppressLint("CoroutineCreationDuringComposition", "MutableCollectionMutableState")
class ProductViewModel:  ViewModel() {
    private val _product = MutableLiveData<List<Product>>()
    val product: LiveData<List<Product>> = _product

    private val _is_loading = MutableLiveData<Boolean>()
    val is_loading: LiveData<Boolean> = _is_loading

    init {
//        CoroutineScope(Dispatchers.IO).launch {
//
//            delay(1000) // Для имитации загрузки
//        }

        _product.value = listOf(
            Product(0, "Banana", 4.8, 287, 3.99, R.drawable.banana),
            Product(1, "Pepper", 4.8, 287, 2.99, R.drawable.pepper),
            Product(2, "Orange", 4.9, 356, 4.99, R.drawable.orange)
        )

        _is_loading.value = true
    }

}