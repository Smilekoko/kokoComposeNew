package com.shiki.kokocomposenew.modifier

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shiki.kokocomposenew.R


@Preview
@Composable
fun ModifierOrderExample() {

    val padding = 16.dp
    Column(
        Modifier
            .background(Color.White)
            //clickable在不同顺序点击效效果不同
            //全局点击
//            .clickable(onClick = {})
            .padding(padding)
            //计算了padding后的点击区域
            .clickable(onClick = {})
            .fillMaxWidth()

    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.pika),
                contentDescription = null,
                modifier = Modifier
                    .size(35.dp) // 设置图片大小
                    .clip(CircleShape), // 裁剪为圆形
                contentScale = ContentScale.Crop // 确保图片填充整个圆形区域
            )
            Column(modifier = Modifier.padding(start = 8.dp)) {
                Text(
                    text = "Pikachu",
                    style = androidx.compose.ui.text.TextStyle(
                        fontWeight = FontWeight.Bold, // 设置字体加粗
                        fontSize = 18.sp, // 设置字体大小
                        textAlign = TextAlign.Center // 设置文本对齐方式
                    )
                )
                Text(text = "ピカチュウ")
            }
        }
        Spacer(Modifier.size(padding))
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        ) {
            Image(painter = painterResource(R.drawable.monai), "")
        }
    }
}