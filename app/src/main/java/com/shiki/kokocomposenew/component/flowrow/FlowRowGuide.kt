package com.shiki.kokocomposenew.component.flowrow

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random


// 定义一个扩展函数，生成随机背景色的 Modifier
fun Modifier.randomBackground(): Modifier = this.background(
    Color(
        red = Random.nextFloat(),
        green = Random.nextFloat(),
        blue = Random.nextFloat(),
        alpha = 1f
    )
)

@OptIn(ExperimentalLayoutApi::class)
@Preview
@Composable
fun FlowRowExample() {

    FlowRow(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
//        horizontalArrangement = Arrangement.spacedBy(8.dp),
//        horizontalArrangement = Arrangement.Center,
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    )
    {
        Text(
            "Price: High to Low",
            modifier = Modifier
                .randomBackground()
                .padding(8.dp)
        )
        Text(
            "Avg rating: 4+",
            modifier = Modifier
                .randomBackground()
                .padding(8.dp)
        )
        Text(
            "Free breakfast",
            modifier = Modifier
                .randomBackground()
                .padding(8.dp)
        )
        Text(
            "Free cancellation",
            modifier = Modifier
                .randomBackground()
                .padding(8.dp)
        )
        Text(
            "£50 pn",
            modifier = Modifier
                .randomBackground()
                .padding(8.dp)
        )
    }
}