package com.shiki.kokocomposenew.animation

import android.util.Log
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * 文本缩放动画
 */
@Preview
@Composable
fun TextMotionAnimatedExample() {

    val infiniteTransition = rememberInfiniteTransition(label = "infinite transition koko")

    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 8f,
        animationSpec = infiniteRepeatable(tween(1000), RepeatMode.Reverse),
        label = "scale"
    )
    val animatedColor by infiniteTransition.animateColor(
        initialValue = Color(0xFF60DDAD),
        targetValue = Color(0xFF4285F4),
        animationSpec = infiniteRepeatable(tween(1000), RepeatMode.Reverse),
        label = "color"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // 定义一个变量来存储 Text 的高度
        val (textHeight, setTextHeight) = remember { mutableStateOf(0.dp) }
        // 获取 LocalDensity
        val density = LocalDensity.current
        Text(
            "Hello",
            modifier = Modifier
                .padding(top = 36.dp)
                .align(Alignment.CenterHorizontally)
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    transformOrigin = TransformOrigin.Center
                }
                .layout { measurable, constraints ->

                    val placeable = measurable.measure(constraints)
                    Log.e("placeable", "${placeable.height} ${placeable.width}")

                    setTextHeight(with(density) { placeable.height.toDp() })

                    layout(placeable.width, placeable.height) {
                        placeable.placeRelative(0, 0)
                    }
                },
            style = LocalTextStyle.current.copy(textMotion = TextMotion.Animated)
        )

        BasicText(
            "Hello Compose", modifier =
            Modifier
                .padding(top = textHeight + 16.dp),
            style = TextStyle(
                color = animatedColor, fontSize = 24.sp
            )
        )
    }


}