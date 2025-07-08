package com.shiki.kokocomposenew.component.text

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shiki.kokocomposenew.ui.theme.KokoComposeNewTheme

class TextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KokoComposeNewTheme { TextScreen() }
        }
    }
}

@Composable
fun TextScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        LazyColumn(
            state = rememberLazyListState(),
            modifier = Modifier,
            contentPadding = innerPadding,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            item { QinyuanSpringSnowColumn() }
        }
    }
}

@Preview
@Composable
fun PreviewTextTextActivity() {
    KokoComposeNewTheme { TextScreen() }
}