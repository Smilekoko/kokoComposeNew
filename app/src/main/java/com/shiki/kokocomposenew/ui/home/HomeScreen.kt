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
import com.shiki.kokocomposenew.component.button.ButtonActivity
import com.shiki.kokocomposenew.component.dialog.DialogActivity
import com.shiki.kokocomposenew.component.pulltorefreshbox.PullToRefreshBoxActivity
import com.shiki.kokocomposenew.component.tablayout.TabLayoutActivity
import com.shiki.kokocomposenew.component.text.TextActivity
import com.shiki.kokocomposenew.bean.HomeScreenItems
import com.shiki.kokocomposenew.component.image.ImageActivity
import com.shiki.kokocomposenew.component.menu.MenuActivity
import com.shiki.kokocomposenew.ui.theme.KokoComposeNewTheme

val homeScreenListItems =
    listOf(
        HomeScreenItems.TextItem,
        HomeScreenItems.ImageItem,
        HomeScreenItems.ButtonItem,
        HomeScreenItems.DialogsItem,
        HomeScreenItems.MenuItem,
        HomeScreenItems.TabLayoutItem,
        HomeScreenItems.PullToRefreshBoxItem,
    )

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
) {

    val list = remember { homeScreenListItems }

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
    list: List<HomeScreenItems> = listOf(HomeScreenItems.DialogsItem)
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
    item: HomeScreenItems = HomeScreenItems.DialogsItem
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
                    is HomeScreenItems.TextItem -> {
                        context.startActivity(Intent(context, TextActivity::class.java))
                    }

                    is HomeScreenItems.IconItem -> {
                    }

                    is HomeScreenItems.ButtonItem -> {
                        context.startActivity(Intent(context, ButtonActivity::class.java))
                    }

                    is HomeScreenItems.DialogsItem -> {
                        context.startActivity(Intent(context, DialogActivity::class.java))
                    }

                    is HomeScreenItems.TabLayoutItem -> {
                        context.startActivity(Intent(context, TabLayoutActivity::class.java))
                    }

                    is HomeScreenItems.PullToRefreshBoxItem -> {
                        context.startActivity(Intent(context, PullToRefreshBoxActivity::class.java))
                    }

                    is HomeScreenItems.ImageItem -> {
                        context.startActivity(Intent(context, ImageActivity::class.java))
                    }

                    is HomeScreenItems.MenuItem -> {
                        context.startActivity(Intent(context, MenuActivity::class.java))
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