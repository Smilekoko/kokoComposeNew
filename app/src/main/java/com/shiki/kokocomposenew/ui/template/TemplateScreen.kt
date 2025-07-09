@file:OptIn(ExperimentalMaterial3Api::class)

package com.shiki.kokocomposenew.ui.template

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shiki.kokocomposenew.template.TemplateActivity
import com.shiki.kokocomposenew.ui.theme.KokoComposeNewTheme

val templates =
    listOf(
        "Login",
    )


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TemplateScreen() {

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Template") })
        }, content = { paddingValues ->
            TemplateScreenContent(modifier = Modifier.padding(paddingValues))
        })

}

@Composable
fun TemplateScreenContent(modifier: Modifier) {
    val context = LocalContext.current
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(templates.size) { index ->
            val template = templates[index]
            Button(
                onClick = {
                    (context as Activity).startActivity(Intent(context, TemplateActivity::class.java).apply {
                        putExtra("templateType", template)
                    })
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Text(text = template, modifier = Modifier.padding(8.dp))
            }
        }
    }
}


@Preview
@Composable
fun TemplateScreenPreview() {
    KokoComposeNewTheme {
        TemplateScreen()
    }
}