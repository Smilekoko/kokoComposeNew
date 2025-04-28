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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.fromHtml
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shiki.kokocomposenew.R

@Preview
@Composable
fun QinyuanSpringSnowColumn() {
    val offset = Offset(5.0f, 10.0f)
    val htmlText = "<a href=\"https://baike.baidu.com/item/%E6%B2%81%E5%9B%AD%E6%98%A5%C2%B7%E9%9B%AA/1410627\">诗词鉴赏</a>"
    val gradientColors = listOf(Cyan, Color.Blue, Color.Red)
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

        Text(
            text = "---毛泽东", modifier = Modifier
                .align(Alignment.End)
                .padding(end = 60.dp, top = 16.dp), style = TextStyle(
                brush = Brush.linearGradient(
                    colors = gradientColors
                )
            )
        )

        Text(modifier = Modifier.padding(top = 32.dp),
            text = buildAnnotatedString {

                withStyle(style = SpanStyle(color = Color.Blue)) { append("沁") }
                append("园春")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Magenta)) {
                    append("雪 ❤\uFE0F")
                }

            }
        )

        Text(
            modifier = Modifier.padding(top = 12.dp),
            text = AnnotatedString.fromHtml(
                htmlText,
                linkStyles = TextLinkStyles(
                    style = SpanStyle(
                        textDecoration = TextDecoration.Underline,
                        fontStyle = FontStyle.Italic, color = Color.Blue
                    )
                )
            )
        )
    }
}