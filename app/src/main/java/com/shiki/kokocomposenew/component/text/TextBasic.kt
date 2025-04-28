package com.shiki.kokocomposenew.component.text

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shiki.kokocomposenew.R

@Preview
@Composable
fun QinyuanSpringSnowColumn() {
    val offset = Offset(5.0f, 10.0f)
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.qinyuancunxue),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Gray, offset = offset, blurRadius = 3f
                )
            )
        )
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = "北国风光，千里冰封，万里雪飘。"
        )
        Text(text = "望长城内外，惟余莽莽，大河上下，顿失滔滔。")
        Text(text = "山舞银蛇，原驰蜡象，欲与天公试比高。")
        Text(text = "须晴日，看红装素裹，分外妖娆。")
        Text(text = "江山如此多娇，引无数英雄竞折腰。")
        Text(text = "惜秦皇汉武，略输文采，唐宗宋祖，稍逊风稍。")
        Text(text = "一代天骄，成吉思汗，只识弯弓射大雕。")
        Text(text = "俱往矣，数风流人物，还看今朝。")
    }
}