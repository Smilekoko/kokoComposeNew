package com.shiki.kokocomposenew.component.button

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.filledTonalButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

//填充按钮
//@Preview
@Composable
fun FilledButtonExample() {
    Button(onClick = {}) {
        Text("Filled")
    }
}

//填充色调按钮
//@Preview
@Composable
fun FilledTonalButtonExample() {
    FilledTonalButton(
        colors = filledTonalButtonColors(
            containerColor = Color(0xFFFF874E),
//            contentColor = Color(0xFFFFFF00),
//            disabledContainerColor = Color(0xFFFFFF00),
//            disabledContentColor = Color(0xFFFFFF00)
        ), onClick = { }) {
        Text("Tonal")
    }
}


//轮廓按钮
//@Preview
@Composable
fun OutlinedButtonExample() {
    OutlinedButton(onClick = { }) {
        Text("Outlined", color = Color(0xFFFF874E))
    }
}

//升高的按钮
//@Preview
@Composable
fun ElevatedButtonExample() {
    ElevatedButton(onClick = { }) {
        Text("Elevated")
    }
}

//文本按钮
@Preview
@Composable
fun TextButtonExample() {
    TextButton(
        onClick = { }
    ) {
        Text("Text Button")
    }
}