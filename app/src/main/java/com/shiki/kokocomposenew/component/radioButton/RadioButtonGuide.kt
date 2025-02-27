package com.shiki.kokocomposenew.component.radioButton

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun RadioButtonSingleSelection() {

    val radioOptions = listOf("Calls", "Missed", "Friends")

    //kotlin的语法糖
    //selectedOption表示MutableState.value
    //onOptionSelected表示MutableState.value 的 setter 方法。
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }


    Column(
        modifier = Modifier
            .selectableGroup()
            .background(Color.White)
    ) {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(horizontal = 16.dp)
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)
                        },
                        role = Role.RadioButton
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(selected = (text == selectedOption), onClick = {})
                Text(text = text, style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}