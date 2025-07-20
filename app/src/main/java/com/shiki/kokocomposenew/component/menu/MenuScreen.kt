package com.shiki.kokocomposenew.component.menu

import android.app.Activity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shiki.kokocomposenew.animation.LikeButtonAnimation
import com.shiki.kokocomposenew.ui.theme.KokoComposeNewTheme

@ExperimentalMaterial3Api
@Composable
fun MenuScreen(backaction: () -> Unit = {}) {
    Scaffold(
        Modifier
            .navigationBarsPadding()
            .imePadding()
            .statusBarsPadding(),
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {
                        backaction.invoke()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "ArrowBack"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(),
                title = { Text("Menu") }
            )
        }
    ) { paddingValue ->
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValue)
        ) {
            item { DropdownMenuGuide() }
            item { DropdownMenuSpinnerDemo() }
        }
    }
}

@Composable
fun DropdownMenuSpinnerDemo() {

    val animaS = listOf(
        "koko",
        "JoJo",
        "Shiki",
        "Pika"
    )
    var selectedItem by remember { mutableStateOf("") }

    DropdownMenuSpinner(
        modifier = Modifier.padding(horizontal = 16.dp),
        selectedItem = selectedItem,
        defaultText = "Select Character...",
        itemList = animaS,
        onItemSelect = { index, item ->
            selectedItem = animaS[index]
        }
    )
}

@Composable
fun DropdownMenuGuide() {
    Column {
        Text("DropdownMenu", modifier = Modifier.padding(start = 16.dp))
        DropdownMenuDemo()
        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp), thickness = 1.dp)
    }
}

@Composable
fun DropdownMenuDemo() {
    var expanded by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.TopCenter)
    ) {
        IconButton(onClick = { expanded = true }) {
            Icon(Icons.Default.MoreVert, contentDescription = "Localized description")
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {

            DropdownMenuItem(text = {
                Text("Menu 1")
            }, onClick = { expanded = false })

            DropdownMenuItem(text = {
                Text("Menu 2")
            }, onClick = { expanded = false })

            DropdownMenuItem(text = {
                Text("Menu 2")
            }, onClick = { expanded = false })

        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MenuScreenPreview() {
    KokoComposeNewTheme {
        MenuScreen()
    }
}