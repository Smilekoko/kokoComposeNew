package com.shiki.kokocomposenew.component.dialog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shiki.kokocomposenew.bean.DialogState
import com.shiki.kokocomposenew.ui.theme.KokoComposeNewTheme


class DialogActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                innerPadding.toString()
                DialogsOptionList(innerPadding)
            }
        }
    }
}

@Composable
fun DialogsOptionList(innerPadding: PaddingValues = PaddingValues(8.dp)) {

    var dialogState by remember { mutableStateOf(DialogState(false, DialogType.SIMPLE)) }

    if (dialogState.showDialog) {
        ShowDialog(dialogState.dialogType, { dialogState = dialogState.copy(showDialog = false) })
    }

    Column(modifier = Modifier.padding(innerPadding)) {
        Button(
            onClick = { dialogState = dialogState.copy(showDialog = true) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(text = "Plain Message Dialog")
        }
    }

}


@Composable
fun ShowDialog(type: DialogType = DialogType.SIMPLE, onDismiss: () -> Unit = {}) {

    when (type) {
        DialogType.SIMPLE -> {
            AlertDialogExample(onDismiss)
        }
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    KokoComposeNewTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            innerPadding.toString()
            DialogsOptionList(innerPadding)
        }
    }
}