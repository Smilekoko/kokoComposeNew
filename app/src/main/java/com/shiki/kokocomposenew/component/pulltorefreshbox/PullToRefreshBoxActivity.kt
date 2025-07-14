package com.shiki.kokocomposenew.component.pulltorefreshbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.shiki.kokocomposenew.ui.theme.KokoComposeNewTheme

@OptIn(ExperimentalMaterial3Api::class)
class PullToRefreshBoxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KokoComposeNewTheme {
                PullToRefreshBoxScreen()
            }
        }
    }
}


@ExperimentalMaterial3Api
@Preview
@Composable
fun PullToRefreshBoxActivityPreview() {
    KokoComposeNewTheme {
        PullToRefreshBoxScreen()
    }
}

