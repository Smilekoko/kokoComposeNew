@file:OptIn(ExperimentalMaterial3Api::class)

package com.shiki.kokocomposenew

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.shiki.kokocomposenew.ui.animation.AnimationScreen
import com.shiki.kokocomposenew.ui.home.HomeScreen
import com.shiki.kokocomposenew.ui.template.TemplateScreen
import com.shiki.kokocomposenew.ui.theme.KokoComposeNewTheme


enum class BottomNavType {
    HOME,
    ANIMATION,
    TEMPLATE
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KokoComposeNewTheme { MainAppContent() }
        }
    }
}

@Composable
fun MainAppContent() {

    val bottomNavType = rememberSaveable { mutableStateOf(BottomNavType.HOME) }

    Column {
        MainScreenContent(modifier = Modifier.weight(1f), bottomNavType.value)
        BottomNavigationContent(modifier = Modifier, bottomNavType)
    }
}

@Composable
fun MainScreenContent(
    modifier: Modifier = Modifier,
    bottomNavType: BottomNavType = BottomNavType.HOME,
) {
    Column(modifier = modifier) {
        Crossfade(bottomNavType) { screen ->
            when (screen) {
                BottomNavType.HOME -> HomeScreen()
                BottomNavType.ANIMATION -> AnimationScreen()
                BottomNavType.TEMPLATE -> TemplateScreen()
            }
        }
    }
}

@Composable
fun BottomNavigationContent(
    modifier: Modifier = Modifier,
    homeScreenState: MutableState<BottomNavType>,
) {
    var animate by remember { mutableStateOf(false) }
    val selectedIconColor = Color.White
    val unselectedIconColor = Color.Gray
    val navItemColors =
        NavigationBarItemDefaults.colors(
            selectedIconColor = selectedIconColor,       // 选中图标颜色
            unselectedIconColor = unselectedIconColor,   // 未选中图标颜色
            selectedTextColor = Color.Black,       // 选中文本颜色（与图标一致）
            unselectedTextColor = Color.Black,   // 未选中文本颜色
            indicatorColor = Color.Blue.copy(alpha = 0.5f)             // 选中项的背景指示器
        )

    NavigationBar(modifier = modifier) {
        NavigationBarItem(
            selected = homeScreenState.value == BottomNavType.HOME,
            icon = {
                Icon(
                    Icons.Default.Home,
                    contentDescription = "Home",
                    tint = if (homeScreenState.value == BottomNavType.HOME) selectedIconColor else unselectedIconColor
                )
            },
            label = {
                Text("Home", style = TextStyle(fontSize = 12.sp))
            },
            onClick = {
                homeScreenState.value = BottomNavType.HOME
                animate = false
            },
            colors = navItemColors
        )
        NavigationBarItem(
            selected = homeScreenState.value == BottomNavType.ANIMATION,
            icon = {
                Icon(
                    ImageVector.vectorResource(R.drawable.play),
                    contentDescription = "Animation",
                    modifier = Modifier.graphicsLayer(
//                        rotationZ = animateFloatAsState(if (animate) 0f else 720f, tween(2000)).value
                    ),
                    tint = if (homeScreenState.value == BottomNavType.ANIMATION) selectedIconColor else unselectedIconColor
                )
            },
            label = {
                Text("Anim", style = TextStyle(fontSize = 12.sp))
            },
            onClick = {
                homeScreenState.value = BottomNavType.ANIMATION
                animate = true
            },
            colors = navItemColors
        )
        NavigationBarItem(
            selected = homeScreenState.value == BottomNavType.TEMPLATE,
            icon = {
                Icon(
                    ImageVector.vectorResource(R.drawable.template),
                    contentDescription = "Template",
                    modifier = Modifier,
                    tint = if (homeScreenState.value == BottomNavType.TEMPLATE) selectedIconColor else unselectedIconColor
                )
            },
            label = {
                Text("Template", style = TextStyle(fontSize = 12.sp))
            },
            onClick = {
                homeScreenState.value = BottomNavType.TEMPLATE
                animate = true
            },
            colors = navItemColors
        )
    }
}

@Preview
@Composable
fun MainAppContentPreview() {
    KokoComposeNewTheme { MainAppContent() }
}