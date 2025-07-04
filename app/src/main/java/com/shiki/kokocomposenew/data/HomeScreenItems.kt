package com.shiki.kokocomposenew.data

sealed class HomeScreenItems {

    object Dialogs : HomeScreenItems()

    val name: String
        get() = when (this) {
            is Dialogs -> "Dialogs"
        }
}
