package com.shiki.kokocomposenew.lottie

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun LottieLoadingView(
    file: String,
    modifier: Modifier = Modifier,
    iterations: Int = 10
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.Asset(file))
    LottieAnimation(composition, modifier = modifier.defaultMinSize(300.dp), iterations = iterations)
}

@Preview
@Composable
fun LottieWorkingLoadingView() {
    LottieLoadingView(
        file = "working.json", modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    )
}