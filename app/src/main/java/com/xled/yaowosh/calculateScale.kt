package com.xled.yaowosh

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.fontscaling.MathUtils.lerp


@SuppressLint("RestrictedApi")
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