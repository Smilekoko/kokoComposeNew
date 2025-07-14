package com.shiki.kokocomposenew.bean

import androidx.annotation.DrawableRes
import java.io.Serializable

class ImageBean(
    val id: Int,
    @DrawableRes val image: Int,
    var name: String = "",
) : Serializable