package com.shiki.kokocomposenew.intrinsic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//Compose 有一项规则，即，子项只能测量一次，测量两次就会引发运行时异常。
//有时需要先收集一些关于子项的信息，然后再测量子项。
//借助 IntrinsicSize[固有特性] ，可以先查询子项，然后再进行实际测量。
@Preview
@Composable
fun IntrinsicSizeExample() {

    Row(
        Modifier
            .background(Color.White)
//            .wrapContentHeight()
            .height(IntrinsicSize.Min)
    )
    {

        Text(
            text = "Text1",
            modifier = Modifier
                .weight(1f)
                .padding(start = 4.dp)
                .wrapContentWidth(Alignment.Start)
        )

        VerticalDivider(
            color = Color.Black, modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
        )

        Text(
            text = "Text1",
            modifier = Modifier
                .weight(1f)
                .padding(end = 4.dp)
                .wrapContentWidth(Alignment.End)
        )

    }
}