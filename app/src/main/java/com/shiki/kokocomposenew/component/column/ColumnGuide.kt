package com.shiki.kokocomposenew.component.column

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Preview
@Composable
fun ColumnExample(messages: List<String> = listOf("koko", "koko")) {
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
    ) {
        messages.forEach {
            Text(it)
        }
    }


}

@Preview
@Composable
fun LazyColumnGuide(
    messages: List<String> = listOf("koko", "koko")
) {
    LazyColumn(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
    ) {
//        item() 用于添加单个列表项
        item {
            Text(text = "First item")
        }

        items(5) { index ->
            Text(text = "Item: $index")
        }

        item {
            Text(text = "Last item")
        }


        items(messages) { message ->
            Text(text = message)
        }

    }
}