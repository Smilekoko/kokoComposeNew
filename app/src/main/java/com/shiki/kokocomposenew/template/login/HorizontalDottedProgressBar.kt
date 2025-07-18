package com.shiki.kokocomposenew.template.login

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun HorizontalDottedProgressBar() {

    val color = MaterialTheme.colorScheme.onPrimary
    val transition = rememberInfiniteTransition()
    val state by transition.animateFloat(
        initialValue = 0f,
        targetValue = 6f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 700, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    DrawCanvas(state, color)

}

@Composable
fun DrawCanvas(state: Float, color: Color) {

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
    ) {
        val radius = (4.dp).value
        val padding = (6.dp).value


        for (i in 1..5) {
            if (i - 1 == state.toInt()) {
                drawCircle(
                    radius = radius * 2,
                    brush = SolidColor(color),
                    center =
                        Offset(
                            x = this.center.x + radius * 2 * (i - 3) + padding * (i - 3),
                            y = this.center.y
                        )
                )
            } else {
                drawCircle(
                    radius = radius,
                    brush = SolidColor(color),
                    center =
                        Offset(
                            x = this.center.x + radius * 2 * (i - 3) + padding * (i - 3),
                            y = this.center.y
                        )
                )
            }
        }
    }
}