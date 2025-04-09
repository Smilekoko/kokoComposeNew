package com.shiki.kokocomposenew.animation

import android.view.View
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shiki.kokocomposenew.modifier.randomBackground

@Preview
@Composable
fun AnimatedVisibilityExample() {
    var visible by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Button(onClick = {
            visible = !visible
        }) {
            Text("Change visible")
        }
        AnimatedVisibility(visible, modifier = Modifier.padding(vertical = 16.dp)) {
            Spacer(
                modifier = Modifier
                    .randomBackground()
                    .fillMaxWidth()
                    .height(150.dp)
            )
        }

        // 类似 View.GONE,会导致padding失效
        Spacer(
            modifier = Modifier
                .randomBackground()
                .fillMaxWidth()
                .height(150.dp)
                .padding(vertical = 16.dp)
        )

    }
}