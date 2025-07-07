package com.shiki.kokocomposenew.data

sealed class HomeScreenItems {

    object Dialogs : HomeScreenItems()
    object TabLayout : HomeScreenItems()

    val name: String
        get() = when (this) {
            is Dialogs -> "Dialogs"
            is TabLayout -> "TabLayout"
        }
}
