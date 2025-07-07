package com.shiki.kokocomposenew.ui.home

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shiki.kokocomposenew.component.dialog.DialogActivity
import com.shiki.kokocomposenew.component.tablayout.TabLayoutActivity
import com.shiki.kokocomposenew.data.HomeScreenItems
import com.shiki.kokocomposenew.data.HomeScreenItems.Dialogs
import com.shiki.kokocomposenew.data.HomeScreenItems.TabLayout
import com.shiki.kokocomposenew.ui.theme.KokoComposeNewTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
) {

    val list = remember { HomeDataProvider.homeScreenListItems }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Home") })
        }, content = { paddingValues ->
            HomeScreenContent(Modifier.padding(paddingValues), list)
        })

}


@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    list: List<HomeScreenItems> = listOf(Dialogs)
) {
    val context = LocalContext.current

    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        items(items = list, itemContent = {
            HomeScreenListItemView(context, it)
        })
    }
}


@Composable
fun HomeScreenListItemView(
    context: Context,
    item: HomeScreenItems = Dialogs
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Button(
            onClick = {
                when (item) {
                    is Dialogs -> {
                        context.startActivity(Intent(context, DialogActivity::class.java))
                    }

                    is TabLayout -> {
                        context.startActivity(Intent(context, TabLayoutActivity::class.java))
                    }

                }
            }, modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = item.name,
                modifier = Modifier.padding(8.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

@Preview
@Composable
fun HomeHomeScreenPreview() {
    KokoComposeNewTheme {
        HomeScreen()
    }
}