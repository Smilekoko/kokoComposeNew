package com.shiki.kokocomposenew.component.text

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun QinyuanSpringSnowColumn() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "北国风光，千里冰封，万里雪飘。")
        Text(text = "望长城内外，惟余莽莽，大河上下，顿失滔滔。")
        Text(text = "山舞银蛇，原驰蜡象，欲与天公试比高。")
        Text(text = "须晴日，看红装素裹，分外妖娆。")
        Text(text = "江山如此多娇，引无数英雄竞折腰。")
        Text(text = "惜秦皇汉武，略输文采，唐宗宋祖，稍逊风稍。")
        Text(text = "一代天骄，成吉思汗，只识弯弓射大雕。")
        Text(text = "俱往矣，数风流人物，还看今朝。")
    }
}