package com.shiki.kokocomposenew.data

sealed class HomeScreenItems {

    object DialogsItem : HomeScreenItems()
    object TabLayoutItem : HomeScreenItems()
    object TextItem : HomeScreenItems()
    object IconItem : HomeScreenItems()
    object ButtonItem : HomeScreenItems()
    object PullToRefreshBoxItem : HomeScreenItems()

    val name: String
        get() = when (this) {
            is IconItem -> "Icon"
            is TextItem -> "Text"
            is ButtonItem -> "Button"
            is DialogsItem -> "Dialogs"
            is TabLayoutItem -> "TabLayout"
            is PullToRefreshBoxItem -> "PullToRefreshBox"
        }
}
