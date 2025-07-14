package com.shiki.kokocomposenew.component.pulltorefreshbox

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.shiki.kokocomposenew.R
import com.shiki.kokocomposenew.bean.ImageBean
import com.shiki.kokocomposenew.ui.theme.KokoComposeNewTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

val imageList =
    listOf(
        ImageBean(1, R.drawable.pika, "皮卡丘"),
        ImageBean(2, R.drawable.suijiangui, "水箭龟"),
        ImageBean(3, R.drawable.penghuolong, "喷火龙"),
        ImageBean(4, R.drawable.genggui, "耿鬼"),
        ImageBean(5, R.drawable.chaomeng, "超梦"),
    )

@ExperimentalMaterial3Api
@Composable
fun PullToRefreshBoxScreen() {

    val context = LocalContext.current
    val state = rememberPullToRefreshState()
    val isRefreshing = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val beans = remember { mutableStateOf(imageList) }

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
                title = { Text("PullToRefreshBox") }
            )
        }
    ) { paddingValue ->
        paddingValue.toString()

        PullToRefreshBox(
            state = state,
            isRefreshing = isRefreshing.value,
            onRefresh = {
                scope.launch {
                    isRefreshing.value = true
                    delay(2000L)
                    beans.value = beans.value.shuffled()
                    isRefreshing.value = false
                }
            },
            modifier = Modifier.padding(paddingValue)
        ) {
            LazyColumn(
                Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                items(beans.value, key = { it.id }) {

                    ListItem(
                        modifier = Modifier
                            .animateItem()
                            .padding(top = 8.dp),
                        headlineContent = {
                            Text(it.name)
                        },
                        leadingContent = {
                            AsyncImage(
                                model = it.image,
                                contentDescription = it.name,
                                modifier = Modifier
                                    .size(64.dp)
                                    .clip(RoundedCornerShape(4.dp))
                            )
                        }
                    )
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun PullToRefreshBoxScreenPreview() {
    KokoComposeNewTheme {
        PullToRefreshBoxScreen()
    }
}