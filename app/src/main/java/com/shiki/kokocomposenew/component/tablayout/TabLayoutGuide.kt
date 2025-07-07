package com.shiki.kokocomposenew.component.tablayout

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shiki.kokocomposenew.R
import com.shiki.kokocomposenew.ui.theme.KokoComposeNewTheme


private enum class DemoTabs(val value: String) {
    APPLE("Apple"),
    GOOGLE("Google"),
    AMAZON("Amazon")
}

data class TabBean(
    val image: Int,
    val title: String,
)

val tabList = listOf(
    TabBean(R.drawable.p1, "Google"),
    TabBean(R.drawable.p2, "Ninja"),
    TabBean(R.drawable.p7, "Ghoul"),
    TabBean(R.drawable.p8, "Loli"),
    TabBean(R.drawable.p9, "蜡笔小新"),
    TabBean(R.drawable.p10, "兵长"),
)

@Composable
fun TabLayoutDemo(paddingValue: PaddingValues = PaddingValues(8.dp)) {

    val selectedIndex = remember { mutableIntStateOf(DemoTabs.APPLE.ordinal) }
    val tabsName = remember { DemoTabs.entries.map { it.value } }

    Column(modifier = Modifier.padding(paddingValue)) {
        TabRow(
            selectedTabIndex = selectedIndex.intValue
        ) {
            tabsName.forEachIndexed { index, title ->
                Tab(selected = index == selectedIndex.intValue, onClick = {
                    when (title) {
                        DemoTabs.APPLE.value -> {
                            selectedIndex.intValue = DemoTabs.APPLE.ordinal
                        }

                        DemoTabs.GOOGLE.value -> {
                            selectedIndex.intValue = DemoTabs.GOOGLE.ordinal
                        }

                        DemoTabs.AMAZON.value -> {
                            selectedIndex.intValue = DemoTabs.AMAZON.ordinal
                        }
                    }
                }) {
                    Text(
                        title,
                        modifier = Modifier.padding(vertical = 8.dp),
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
        }

        ScrollableListOfTabs()
    }

}

@Composable
fun ScrollableListOfTabs() {
    val tabs = remember { tabList }
    val selectedIndex = remember { mutableIntStateOf(0) }

    ScrollableTabRow(
        selectedTabIndex = selectedIndex.intValue,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 0.dp),
        edgePadding = 16.dp,
        divider = {},
        indicator = { tabPositions -> },
    ) {
        tabs.forEachIndexed { index, item ->
            val selected = selectedIndex.intValue == index
            Tab(
                modifier = Modifier.padding(vertical = 8.dp),
                selected = selected,
                onClick = {
                    selectedIndex.intValue = index
                }) {
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(
                        width = 1.dp,
                        color = if (selected) MaterialTheme.colorScheme.primary else Color.LightGray
                    )
                ) {
                    Row {
                        Image(
                            painter = painterResource(item.image),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(start = 8.dp, top = 8.dp, bottom = 8.dp)
                                .size(20.dp)
                                .clip(CircleShape)
                        )

                        Text(
                            text = item.title,
                            style = MaterialTheme.typography.labelMedium,
                            modifier = Modifier
                                .padding(8.dp)
                                .align(Alignment.CenterVertically)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun TabLayoutDemoPreview() {
    KokoComposeNewTheme {
        TabLayoutDemo()
    }
}