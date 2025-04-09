package com.shiki.kokocomposenew.component.progressindicator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shiki.kokocomposenew.modifier.randomBackground
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


suspend fun loadProgress(updateProgress: (Float) -> Unit) {
    for (i in 1..100) {
//        progress：指示器显示的当前进度。传递 Float 介于 0.0 和 1.0 之间。
        updateProgress(i.toFloat() / 100)
        delay(100)
    }
}

@Preview
@Composable
fun LinearProgressIndicatorGuideExample() {

    var currentProgress by remember { mutableStateOf(0f) }
    val scope = rememberCoroutineScope() // Create a coroutine scope

    Column(
        modifier = Modifier
            .fillMaxSize()
            .randomBackground()
    ) {
        Button(
            onClick = {
                scope.launch {
                    loadProgress {
                        currentProgress = it
                    }
                }
            })
        {
            Text("Start loading")
        }

        CircularProgressIndicator(
            modifier = Modifier
                .padding(vertical = 10.dp)
                .size(64.dp)
                .align(Alignment.CenterHorizontally),
            color = Color.Cyan,
            trackColor = Color.Gray
        )

        LinearProgressIndicator(
            progress = {
                currentProgress
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

    }
}