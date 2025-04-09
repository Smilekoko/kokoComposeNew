package com.shiki.kokocomposenew.component.modalbottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ModalBottomSheetExample() {

    var showBottomSheet by remember { mutableStateOf(true) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false, // 是否跳过部分展开
        confirmValueChange = { sheetValue ->
            // 仅允许程序控制状态变化，禁止用户拖动
//            true // 返回 false 表示拒绝用户触发的状态变化

            // 只允许在部分展开和完全展开之间切换，禁止隐藏
            sheetValue != SheetValue.Hidden
        }
    )

    // 默认部分展开
    LaunchedEffect(sheetState) {
        sheetState.partialExpand() // 默认部分展开
    }

    val scope = rememberCoroutineScope()

    if (showBottomSheet) {
        Box(modifier = Modifier.fillMaxSize()) {
            ModalBottomSheet(
                sheetState = sheetState,
                modifier = Modifier.heightIn(max = 500.dp, min = 250.dp), // 限制最大高度,
                onDismissRequest = {},
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(500.dp)
                        .background(Color.Cyan)
                ) {
                    Button(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        onClick = {
                            //收起
//                            scope.launch { sheetState.hide() }.invokeOnCompletion {
//                                if (!sheetState.isVisible) {
//                                    showBottomSheet = false
//                                }
//                            }

                            // 切换展开状态
                            scope.launch {
                                if (sheetState.currentValue == SheetValue.PartiallyExpanded) {
                                    sheetState.expand() // 展开到500dp
                                } else {
                                    sheetState.partialExpand() // 收起至250dp
                                }
                            }

                        }) {
                        Text("Hide bottom sheet")
                    }
                }

            }
        }
    }
}