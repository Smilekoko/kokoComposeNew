package com.shiki.kokocomposenew.animation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shiki.kokocomposenew.modifier.randomBackground


@Preview
@Composable
fun AnimateFloatAsStateExample() {

    var visible by remember { mutableStateOf(true) }

    val animatedAlpha by animateFloatAsState(
        targetValue = if (visible) 1.0f else 0f,
        label = "alpha",
        animationSpec = tween(
            durationMillis = 2500, // 动画持续时间（毫秒）
            easing = LinearEasing // 缓动函数（控制速率变化）
        ),
    )
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Button(onClick = {
            visible = !visible
        }) {
            Text("Change visible")
        }

        Spacer(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .graphicsLayer {
                    alpha = animatedAlpha
                }
                .randomBackground()
                .fillMaxWidth()
                .height(150.dp)

        )

        // 类似 View.GONE,会导致padding失效
        Spacer(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .randomBackground()
                .fillMaxWidth()
                .height(150.dp)
        )

    }

}

@Preview
@Composable
fun AnimateColorAsStateExample() {

    var changeColor by remember { mutableStateOf(true) }

    val animatedColor by animateColorAsState(
        if (changeColor) Color.Green else Color.Blue,
        label = "color"
    )

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Button(onClick = {
            changeColor = !changeColor
        }) {
            Text("Change Color")
        }

        Spacer(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .drawBehind {
//                    此选项的性能高于使用 Modifier.background ()。
//                    对于一次性颜色设置，Modifier.background() 是可接受的，
//                    但如果要让颜色随时间动画化，这可能会导致重组次数过多。
                    drawRect(animatedColor)
                }
                .fillMaxWidth()
                .height(150.dp)

        )
    }
}