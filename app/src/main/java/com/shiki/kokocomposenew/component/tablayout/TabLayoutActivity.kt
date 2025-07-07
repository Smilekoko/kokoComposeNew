@file:OptIn(ExperimentalMaterial3Api::class)

package com.shiki.kokocomposenew.component.tablayout

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.shiki.kokocomposenew.ui.theme.KokoComposeNewTheme

class TabLayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KokoComposeNewTheme {
                TabTabLayoutScreen()
            }
        }
    }
}

@Composable
fun TabTabLayoutScreen() {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {
                        (context as Activity).finish()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "ArrowBack"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(),
                title = { Text("TabLayout") }
            )
        }
    ) { paddingValue ->
        paddingValue.toString()
        TabLayoutDemo(paddingValue)
    }
}

@Preview(showBackground = true)
@Composable
fun TabLayoutPreview() {
    KokoComposeNewTheme {
        TabTabLayoutScreen()
    }
}