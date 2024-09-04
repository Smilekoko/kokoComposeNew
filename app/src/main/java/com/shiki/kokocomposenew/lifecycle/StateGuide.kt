package com.shiki.kokocomposenew.lifecycle

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember

@Composable
fun StateComponent() {
    //使用 mutableStateOf 来创建一个可观察的状态对象。
    //这个状态对象可以通过 remember 来保存在组件树中，使其在重组时保持不变。
    val myState = remember { mutableIntStateOf(0) } // 创建一个可观察的状态对象
}