package com.shiki.kokocomposenew.template.cleanhome

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.shiki.kokocomposenew.R
import com.shiki.kokocomposenew.ui.theme.KokoComposeNewTheme


@Composable
fun CleanHomeScreen() {
    Scaffold { paddingValues -> paddingValues.toString() }
}

@Composable
fun CardFunction(
    modifier: Modifier = Modifier,
    icon: Int,
    title: Int
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = modifier
            .height(115.dp),
    ) {
        Column {
            AsyncImage(
                model = icon,
                contentDescription = "",
                modifier = Modifier.padding(start = 30.dp, top = 30.dp)
            )
            Text(
                text = stringResource(title),
                color = Color(0xFF0A0C10),
                modifier = Modifier.padding(
                    top = 12.dp, start = 22.dp
                )
            )
        }

    }
}

@Preview
@Composable
fun CardFunctionPreview() {
    CardFunction(modifier = Modifier.fillMaxWidth(), R.drawable.icon_picture, R.string.picture_clean)
}

@Preview
@Composable
fun CleanHomeScreenPreview() {
    KokoComposeNewTheme {
        CleanHomeScreen()
    }
}