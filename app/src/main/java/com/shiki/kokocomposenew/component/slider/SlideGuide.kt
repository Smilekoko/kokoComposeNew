package com.shiki.kokocomposenew.component.slider

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun SliderExample() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Column(modifier = Modifier.background(Color.White)) {
        Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
        Text(text = sliderPosition.toString())
    }
}

@Preview
@Composable
fun SliderAdvancedExample() {
    var sliderPosition by remember { mutableFloatStateOf(5f) }
    Column(modifier = Modifier.background(Color.White)) {
        Slider(
            value = sliderPosition,
            colors = SliderDefaults.colors(
                thumbColor = Color.Blue,
                activeTrackColor = Color.Green,
                inactiveTrackColor = Color.Gray
            ), steps = 9,
            valueRange = 0f..50f,
            onValueChange = { sliderPosition = it })
        Text(text = sliderPosition.toString())
    }
}