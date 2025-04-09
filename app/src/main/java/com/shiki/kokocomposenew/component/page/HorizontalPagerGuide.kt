package com.shiki.kokocomposenew.component.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shiki.kokocomposenew.R


@Preview
@Composable
fun HorizontalPagerExample() {

    val pagerState = rememberPagerState(pageCount = { 10 })
    HorizontalPager(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth(),
        state = pagerState
    ) { page ->

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
        ) {
            Text("$page page")
            Image(painter = painterResource(R.drawable.pika), "")
        }
    }

}