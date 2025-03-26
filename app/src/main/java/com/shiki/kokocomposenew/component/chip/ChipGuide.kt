package com.shiki.kokocomposenew.component.chip

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun AssistChipExample() {
    AssistChip(onClick = {},
        label = {
            Text(text = "AssistChip")
        },
        leadingIcon = {
            Icon(
                Icons.Filled.Settings, contentDescription = "",
                Modifier.size(AssistChipDefaults.IconSize)
            )

        })
}