package com.shiki.kokocomposenew.component.page

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shiki.kokocomposenew.R
import kotlinx.coroutines.launch

@Preview
@Composable
fun VerticalPagerExample() {

    val TAG = remember { "VerticalPagerExample" }
    val pagerState = rememberPagerState(pageCount = { 10 })

    //监听状态改变
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            Log.d(TAG, "Page changed to $page")
        }
    }

    VerticalPager(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        state = pagerState,
    ) { page ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.Center // 确保内容居中
        ) {

            val coroutineScope = rememberCoroutineScope()
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable {
                        coroutineScope.launch {
                            // Call scroll to on pagerState
//                            pagerState.scrollToPage(page + 1)
                            pagerState.animateScrollToPage(page + 1)
                        }
                    }
            ) {
                Text("$page page")
                Image(painter = painterResource(R.drawable.pika), "")
            }
        }

    }

}