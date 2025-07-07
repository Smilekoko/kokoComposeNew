package com.shiki.kokocomposenew

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.shiki.kokocomposenew.ui.home.HomeScreen
import com.shiki.kokocomposenew.ui.theme.KokoComposeNewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KokoComposeNewTheme {
                HomeScreen()
            }
        }
    }
}

