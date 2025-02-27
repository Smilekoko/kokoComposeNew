package com.shiki.kokocomposenew.component.switch

import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun SwitchExample() {

    var checked by remember { mutableStateOf(false) }

    Switch(
        checked = checked,
        onCheckedChange = { checked = it },
        colors = SwitchDefaults.colors(
            uncheckedTrackColor = Color(0xFF666666),
            uncheckedThumbColor = Color(0xFF27E6FF),

            checkedTrackColor = Color(0x8049FFA0),
            checkedThumbColor = Color(0xFFFFB160),
        )
    )

}