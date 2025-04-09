package com.shiki.kokocomposenew.component.lazygrid

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shiki.kokocomposenew.R
import com.shiki.kokocomposenew.bean.ImageBean


@Preview
@Composable
fun LazyVerticalGridExample() {
    
    val imageList = remember {
        mutableStateListOf(
            ImageBean(1, R.drawable.pika),
            ImageBean(2, R.drawable.suijiangui),
            ImageBean(3, R.drawable.penghuolong),
            ImageBean(4, R.drawable.genggui),
            ImageBean(5, R.drawable.chaomeng),
        )
    }

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
        items(imageList,
            key = {
                //提供稳定的键可使项状态在发生数据集更改后保持一致：
                //键的类型必须受 Bundle 支持
                it.id
            }) {
            Image(
                modifier = Modifier
                    .padding(5.dp)
                    // 保持图片宽高比为1:1
                    .aspectRatio(1f)
                    .animateItem(
                        fadeInSpec = tween(durationMillis = 200),
                        fadeOutSpec = tween(durationMillis = 100),
                        placementSpec = spring(
                            stiffness = Spring.StiffnessLow,
                            dampingRatio = Spring.DampingRatioMediumBouncy
                        )
                    )
                    .clickable {
                        // 点击时从列表中移除该项
                        imageList.remove(it)
                    },
                painter = painterResource(it.image),
                contentDescription = ""
            )
        }
    }
}