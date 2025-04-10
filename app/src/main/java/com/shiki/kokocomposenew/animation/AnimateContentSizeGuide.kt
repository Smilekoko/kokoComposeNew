package com.shiki.kokocomposenew.animation

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 *  改变大小
 */
@Preview
@Composable
fun AnimateContentSizeExample() {
    var expanded by remember { mutableStateOf(false) }
//Box有个问题如果外部ComposeView全屏高度,会导致Box设置高度失效
    Box(
        modifier = Modifier
            .background(Color.Yellow)
            .animateContentSize { initialValue, targetValue ->

            }
            .height(if (expanded) 400.dp else 200.dp)
            .fillMaxWidth()
            .clickable(
                //跟踪交互状态：记录组件当前的交互行为（如 Pressed、Dragged、Hovered 等）。
                //控制视觉反馈：与 indication 配合，决定是否显示水波纹或其他点击效果。
                //自定义交互逻辑：可以通过监听 interactionSource 实现复杂的交互效果。
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                expanded = !expanded
            }
    ) {
        Text("组合项的大小添加动画", modifier = Modifier.align(Alignment.Center))
    }

}