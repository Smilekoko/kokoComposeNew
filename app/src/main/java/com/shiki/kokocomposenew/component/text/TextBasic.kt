package com.shiki.kokocomposenew.component.text

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
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
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.fromHtml
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.shiki.kokocomposenew.R

@Preview
@Composable
fun QinyuanSpringSnowColumn() {
    val offset = Offset(5.0f, 10.0f)
    val htmlText = "<a href=\"https://baike.baidu.com/item/%E6%B2%81%E5%9B%AD%E6%98%A5%C2%B7%E9%9B%AA/1410627\">诗词鉴赏</a>"
    val gradientColors = listOf(Cyan, Color.Blue, Color.Red)
    val lineStyle =
        LocalTextStyle.current.merge(
            TextStyle(
                lineHeight = 2.5.em,
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                ),
                lineHeightStyle = LineHeightStyle(
                    alignment = LineHeightStyle.Alignment.Center,
                    trim = LineHeightStyle.Trim.None
                )
            )
        )

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
            text = "北国风光，千里冰封，万里雪飘。", style = lineStyle
        )
        Text(text = "望长城内外，惟余莽莽，大河上下，顿失滔滔。", style = lineStyle)
        Text(text = "山舞银蛇，原驰蜡象，欲与天公试比高。", style = lineStyle)
        Text(text = "须晴日，看红装素裹，分外妖娆。", style = lineStyle)
        Text(text = "江山如此多娇，引无数英雄竞折腰。", style = lineStyle)
        Text(text = "惜秦皇汉武，略输文采，唐宗宋祖，稍逊风稍。", style = lineStyle)
        Text(text = "一代天骄，成吉思汗，只识弯弓射大雕。", style = lineStyle)
        Text(text = "俱往矣，数风流人物，还看今朝。", style = lineStyle)

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

        Text(
            modifier = Modifier.padding(horizontal = 32.dp),
            text = "《沁园春·雪》是无产阶级革命家毛泽东创作的一首词。该词上片描写北国壮丽的雪景，纵横千万里，展示了大气磅礴、旷达豪迈的意境，抒发了词人对祖国壮丽河山的热爱。下片议论抒情，重点评论历史人物，歌颂当代英雄，抒发无产阶级要做世界的真正主人的豪情壮志。全词熔写景、议论和抒情于一炉，意境壮美，气势恢宏，感情奔放，胸襟豪迈，颇能代表毛泽东诗词的豪放风格。"
        )
        Text(
            modifier = Modifier.padding(horizontal = 32.dp),
            text = "\"沁园春·雪\" is a poem written by Mao Zedong, a proletarian revolutionary. The first part of the poem describes the magnificent snow scene in the north, which stretches for thousands of miles, showing a majestic, broad-minded and heroic artistic conception, and expressing the poet's love for the magnificent mountains and rivers of the motherland. The second part is argumentative and lyrical, focusing on commenting on historical figures, praising contemporary heroes, and expressing the proletariat's ambition to be the true master of the world. The whole poem combines description, argument and lyricism, with a magnificent artistic conception, magnificent momentum, unrestrained emotions and a heroic mind, which can well represent the bold style of Mao Zedong's poems."
        )
    }
}