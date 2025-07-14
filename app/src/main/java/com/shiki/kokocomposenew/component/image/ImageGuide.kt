package com.shiki.kokocomposenew.component.image

import android.app.Activity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.shiki.kokocomposenew.R
import com.shiki.kokocomposenew.ui.theme.KokoComposeNewTheme

@ExperimentalMaterial3Api
@Composable
fun ImageScreen() {

    val context = LocalContext.current

    Scaffold(
        Modifier
            .navigationBarsPadding()
            .imePadding()
            .statusBarsPadding(),
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
                title = { Text("Image") }
            )
        }
    ) { paddingValue ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValue)
                .padding(horizontal = 16.dp)
        ) {
            item { ImageContentScale() }
            item { ImageClip() }
            item { ImageBorder() }
        }
    }
}

@Composable
fun ImageContentScale() {
    val imageModifier = Modifier
        .padding(top = 8.dp)
        .size(120.dp)
        .border(BorderStroke(1.dp, Color.Black))
        .background(Color.Yellow)

    Column {
        Text("Image contentScale")
        AsyncImage(
            model = R.drawable.monai,
            contentDescription = "莫奈",
            contentScale = ContentScale.Fit,
            modifier = imageModifier
                .align(Alignment.CenterHorizontally)
        )
        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp), thickness = 1.dp)
    }
}

@Composable
fun ImageClip() {
    Column {
        Text("Image clip")
        AsyncImage(
            model = R.drawable.chaomeng,
            contentDescription = "超梦",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterHorizontally)
                .padding(top = 8.dp)
                .clip(CircleShape)

        )
        AsyncImage(
            model = R.drawable.pika,
            contentDescription = "皮卡丘",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterHorizontally)
                .padding(top = 8.dp)
                .clip(RoundedCornerShape(16.dp))

        )
        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp), thickness = 1.dp)
    }
}

@Composable
fun ImageBorder() {
    val rainbowColorsBrush = remember {
        Brush.sweepGradient(
            listOf(
                Color(0xFF9575CD),
                Color(0xFFBA68C8),
                Color(0xFFE57373),
                Color(0xFFFFB74D),
                Color(0xFFFFF176),
                Color(0xFFAED581),
                Color(0xFF4DD0E1),
                Color(0xFF9575CD)
            )
        )
    }

    Column {
        Text("Image border")
        AsyncImage(
            model = R.drawable.penghuolong,
            contentDescription = "喷火龙",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterHorizontally)
                .border(
                    BorderStroke(4.dp, rainbowColorsBrush),
                    CircleShape
                )
                .padding(8.dp)
                .clip(CircleShape)
        )
        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp), thickness = 1.dp)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ImageScreenPreview() {

    KokoComposeNewTheme {
        ImageScreen()
    }
}