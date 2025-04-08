package com.shiki.kokocomposenew.component.row

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun RowExample(messages: List<String> = listOf("koko", "koko", "koko")) {
    Row(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
    ) {
        messages.forEach {
            Text(modifier = Modifier.padding(5.dp), text = it)
        }
    }


}