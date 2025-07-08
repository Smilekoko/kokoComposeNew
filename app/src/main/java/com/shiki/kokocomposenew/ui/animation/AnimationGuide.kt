package com.shiki.kokocomposenew.ui.animation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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