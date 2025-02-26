package com.shiki.kokocomposenew.dialog

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@Preview
@Composable
fun AlertDialogExample() {

    AlertDialog(

        icon = {
            Icon(Icons.Default.Favorite, contentDescription = "Favorite Icon")
        },
        title = {
            Text(text = "AlertDialog")
        },
        text = {
            Text(text = "This is an example of an alert dialog with buttons.")
        },
        onDismissRequest = {

        },
        confirmButton = {
            TextButton(onClick = {}) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(onClick = {}) {
                Text("Dismiss")
            }
        }
    )

}