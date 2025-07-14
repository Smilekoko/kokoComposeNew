package com.shiki.kokocomposenew.bean

sealed class HomeScreenItems {

    data object DialogsItem : HomeScreenItems()
    data object TabLayoutItem : HomeScreenItems()
    data object TextItem : HomeScreenItems()
    data object IconItem : HomeScreenItems()
    data object ButtonItem : HomeScreenItems()
    data object PullToRefreshBoxItem : HomeScreenItems()
    data object ImageItem : HomeScreenItems()
    data object MenuItem : HomeScreenItems()

    val name: String
        get() = when (this) {
            is IconItem -> "Icon"
            is TextItem -> "Text"
            is ButtonItem -> "Button"
            is DialogsItem -> "Dialogs"
            is TabLayoutItem -> "TabLayout"
            is PullToRefreshBoxItem -> "PullToRefreshBox"
            is ImageItem -> "Image"
            is MenuItem -> "Menu"
        }
}