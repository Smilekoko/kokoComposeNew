package com.shiki.kokocomposenew.effect

import android.util.Log
import androidx.compose.animation.core.Animatable
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

//https://developer.android.com/develop/ui/compose/side-effects
@Composable
fun EffectComponent() {

    //在可组合项的整个生命周期内执行工作并能够调用 suspend 函数，请使用 LaunchedEffect 可组合项。
    //如果 LaunchedEffect 离开组合，则协程将被取消。
    val pulseRateMs by remember { mutableLongStateOf(3000L) }
    val alpha = remember { Animatable(1f) }
    LaunchedEffect(pulseRateMs) { // Restart the effect when the pulse rate changes
        while (isActive) {
            delay(pulseRateMs) // Pulse the alpha every pulseRateMs to alert the user
            alpha.animateTo(0f)
            alpha.animateTo(1f)
        }
    }
}

@Composable
fun RememberCoroutineScopeComponent() {
    // 可组合项外部启动协程，但要调整范围，使其在离开组合后自动取消，使用 rememberCoroutineScope。
    val scope = rememberCoroutineScope()
    Button(
        onClick = {
            scope.launch {
                Log.e("RememberCoroutineScopeComponent", "click ~")
            }
        }
    ) {
        Text("Press me")
    }
}

@Composable
fun RememberUpdatedState(onTimeout: () -> Unit) {
    //使用 rememberUpdatedState 创建对此值的引用，该引用可以捕获和更新。
    //currentOnTimeout的最新的超时回调被引用,不会重新触发LaunchedEffect
    val currentOnTimeout by rememberUpdatedState(onTimeout)
//    LaunchedEffect 在其中一个关键参数发生更改时重新启动。用true表示只会触发一次
    LaunchedEffect(true) {
        delay(5000L)
        Log.e("RememberCoroutineScopeComponent", "click ~")
        currentOnTimeout.invoke()
    }
}