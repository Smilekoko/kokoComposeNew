package com.shiki.kokocomposenew.data

sealed class HomeScreenItems {

    object DialogsItem : HomeScreenItems()
    object TabLayoutItem : HomeScreenItems()
    object TextItem : HomeScreenItems()
    object IconItem : HomeScreenItems()

    val name: String
        get() = when (this) {
            is DialogsItem -> "Dialogs"
            is TabLayoutItem -> "TabLayout"
            is TextItem -> "Text"
            is IconItem -> "Icon"
        }
}
