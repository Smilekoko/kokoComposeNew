package com.shiki.kokocomposenew.bean

import com.shiki.kokocomposenew.component.dialog.DialogType

data class DialogState(
    var showDialog: Boolean, var dialogType: DialogType
)