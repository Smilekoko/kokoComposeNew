package com.shiki.kokocomposenew.modifier

import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

// 定义一个扩展函数，生成随机背景色的 Modifier
fun Modifier.randomBackground(): Modifier {
//    return this
    return this.background(
        Color(
            red = Random.nextFloat(),
            green = Random.nextFloat(),
            blue = Random.nextFloat(),
            alpha = 1f
        )
    )
}
