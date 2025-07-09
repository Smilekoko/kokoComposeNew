package com.shiki.kokocomposenew.animation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shiki.kokocomposenew.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Preview
@Composable
fun LikeButtonAnimationItem() {

    Column {
        Text("Like Button Animation with Keyframes")
        LikeButtonAnimation()
        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp), thickness = 1.dp)
    }

}

/**
 * graphicsLayer 实现动画效果
 */
@Composable
fun LikeButtonAnimation() {
    var liked by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    var scale by remember { mutableFloatStateOf(1f) }

    IconButton(
        onClick = {
            liked = !liked
            scope.launch {
                scale = 1.3f
                delay(100)
                scale = 1f
            }
        },
        modifier = Modifier.graphicsLayer(scaleX = scale, scaleY = scale)
    ) {
        Icon(
            Icons.Default.Favorite,
            contentDescription = "Like",
            tint = if (liked) Color.Red else Color.Gray,
            modifier = Modifier.size(24.dp)
        )

    }
}

@Preview
@Composable
fun ShimmerLoadingAnimationItem() {
    Column {
        Text("Shimmer Loading Animation")
        ShimmerLoadingAnimation()
        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp), thickness = 1.dp)
    }
}

@Composable
fun ShimmerLoadingAnimation() {
    val infiniteTransition = rememberInfiniteTransition()
    val translateAnim = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            //LinearOutSlowInEasing 开始阶段以匀速运行，然后逐渐减速直到结束
            animation = tween(1500, easing = LinearOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        )
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(Color(0xFF3F51B5))

    ) {

        Image(
            ImageBitmap.imageResource(R.drawable.wallpaper),
            contentDescription = "",
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.linearGradient(
                        colors = listOf(Color.Transparent, Color.White.copy(alpha = 0.4f), Color.Transparent),
                        start = Offset(translateAnim.value - 500f, 0f),
                        end = Offset(translateAnim.value, 500f)
                    )
                )
        )
    }
}


@Preview
@Composable
fun AnimateVisibilityItem() {
    Column {
        Text("Animate view visibility via  AnimateVisibility()")
        AnimateVisibilityDemo()
        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp), thickness = 1.dp)
    }
}

@Composable
fun AnimateVisibilityDemo() {
    var expanded by remember { mutableStateOf(true) }
    FloatingActionButton(onClick = {
        expanded = !expanded
    }, modifier = Modifier.padding(top = 16.dp, start = 16.dp)) {
        Row(modifier = Modifier.padding(horizontal = 16.dp)) {
            Icon(
                painter = painterResource(R.drawable.ic_twitter),
                contentDescription = ""
            )
            AnimatedVisibility(expanded, modifier = Modifier.align(Alignment.CenterVertically)) {
                Text("Tweet", modifier = Modifier.padding(start = 8.dp))
            }
        }
    }
}