package com.shiki.kokocomposenew.lifecycle

import androidx.compose.animation.core.Animatable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive

@Composable
fun StateComponent() {
    //使用 mutableStateOf 来创建一个可观察的状态对象。
    //这个状态对象可以通过 remember 来保存在组件树中，使其在重组时保持不变。
    val myState = remember { mutableIntStateOf(0) } // 创建一个可观察的状态对象

    // Allow the pulse rate to be configured, so it can be sped up if the user is running
// out of time
    var pulseRateMs by remember { mutableStateOf(3000L) }
    val alpha = remember { Animatable(1f) }
    LaunchedEffect(pulseRateMs) { // Restart the effect when the pulse rate changes
        while (isActive) {
            delay(pulseRateMs) // Pulse the alpha every pulseRateMs to alert the user
            alpha.animateTo(0f)
            alpha.animateTo(1f)
        }
    }
}