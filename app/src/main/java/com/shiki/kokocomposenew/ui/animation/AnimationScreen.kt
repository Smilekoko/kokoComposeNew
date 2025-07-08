package com.shiki.kokocomposenew.ui.animation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shiki.kokocomposenew.ui.theme.KokoComposeNewTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimationScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Animations") })
        }
    ) { paddingValue ->
        paddingValue.toString()
        AnimationScreenContent(modifier = Modifier.padding(paddingValue))
    }
}

@Composable
fun AnimationScreenContent(modifier: Modifier = Modifier) {
    LazyColumn(
        state = rememberLazyListState(),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(horizontal = 16.dp),
    ) {
        item { LikeButtonAnimationItem() }
    }
}

@Preview
@Composable
fun AnimationScreenPreview() {
    KokoComposeNewTheme {
        AnimationScreen()
    }
}