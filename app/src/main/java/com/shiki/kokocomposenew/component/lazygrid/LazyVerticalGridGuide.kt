package com.shiki.kokocomposenew.component.lazygrid

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shiki.kokocomposenew.R


@Preview
@Composable
fun LazyVerticalGridExample() {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
//        columns = GridCells.Adaptive(minSize = 128.dp)//最小尺寸
        columns = GridCells.Fixed(2), // 每行固定显示两列
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),//padding
        verticalArrangement = Arrangement.spacedBy(16.dp),//每item垂直间距
        horizontalArrangement = Arrangement.spacedBy(8.dp),//每水平间距

    ) {
        items(5,
            key = { index ->
                //提供稳定的键可使项状态在发生数据集更改后保持一致：
                index
            }) {
            Image(
                modifier = Modifier
                    .padding(5.dp)
                    .aspectRatio(1f), // 保持图片宽高比为1:1,
                painter = painterResource(R.drawable.pika),
                contentDescription = ""
            )
        }
    }
}