package com.shiki.kokocomposenew.animation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.shiki.kokocomposenew.modifier.randomBackground
import kotlin.math.roundToInt


/**
 * 属性值动画
 */
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

/**
 * 变颜色动画
 */
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


/**
 * 位置偏移动画
 */
@Preview
@Composable
fun AnimateIntOffsetAsStateExample() {

    var moved by remember { mutableStateOf(false) }
    // 在正确的密度环境下转换 dp → px
    val pxToMove = with(LocalDensity.current) {
        100.dp.toPx().roundToInt()
    }
    //定义位移动画
    val offset by animateIntOffsetAsState(
        targetValue = if (moved) {
            IntOffset(pxToMove, pxToMove)
        } else {
            IntOffset.Zero
        }
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .offset {
                    offset
                }
                .background(Color.Cyan)
                .size(100.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    moved = !moved
                }
        ) {
            Text("组合项的位置添加动画", modifier = Modifier.align(Alignment.Center))
        }

    }

}

/**
 * 位置偏移动画 结合 Modifier.layout{ } 确保位置和尺寸传递
 */
@Preview
@Composable
fun AnimateIntOffsetAsStateLayoutExample() {

    var toggled by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White)
    ) {
        Button(onClick = {
            toggled = !toggled
        }) {
            Text("位置偏移动画 和 Modifier.layout{ }")
        }

        val offsetTarget = if (toggled) {
            IntOffset(150, 150)
        } else {
            IntOffset.Zero
        }

        val offset = animateIntOffsetAsState(
            targetValue = offsetTarget, label = "offset"
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Blue)
        )
        Box(
            modifier = Modifier
                //measurable 是一个 Measurable 类型的对象，表示当前需要测量的子组件。
                //constraints 是一个 Constraints 类型的对象，表示父组件对当前组件的约束条件。
                .layout { measurable, constraints ->
                    //父组件通过这些约束来限制子组件的大小
                    val placeable = measurable.measure(constraints)
                    //isLookingAhead 是一个布尔值，用于判断是否处于预览状态。
                    // 在预览状态下，动画可能不会运行，因此直接使用目标偏移量 offsetTarget。
                    val offsetValue = if (isLookingAhead) offsetTarget else offset.value

                    //代码定义了当前组件的最终尺寸。
                    layout(placeable.width + offsetValue.x, placeable.height + offsetValue.y) {
                        //这行代码的作用是将 子组件(可组合部分UI) 放置在指定的位置
                        placeable.placeRelative(offsetValue)
                    }
                }
                .size(100.dp)
                .background(Color.Magenta)
        ) { }
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Green)
        )


    }

}


/**
 * 可组合项的内边距添加 dp动画
 */
@Preview
@Composable
fun AnimateDpAsStateExample() {

    var toggled by remember {
        mutableStateOf(false)
    }

    val animatedPadding by animateDpAsState(
        targetValue = if (toggled) 0.dp else 20.dp,
        label = "padding"
    )

    //搜集点击状态
    val mutableInteractionSource = remember {
        MutableInteractionSource()
    }
    val pressed = mutableInteractionSource.collectIsPressedAsState()
    val elevation = animateDpAsState(
        targetValue = if (pressed.value) {
            32.dp
        } else {
            8.dp
        },
        label = "elevation"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .aspectRatio(1f)
                .fillMaxSize()
                .padding(animatedPadding)
                .graphicsLayer {
                    this.shadowElevation = elevation.value.toPx()
                }
                .background(Color(0xff53D9A1))
                .clickable(
                    interactionSource = mutableInteractionSource,
                    indication = null
                ) {
                    toggled = !toggled
                }) {

        }
    }
}