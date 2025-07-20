package com.shiki.kokocomposenew.component.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.shiki.kokocomposenew.R

/**
 * 使用DropdownMenu实现Spinner效果
 */
@Composable
fun <E> DropdownMenuSpinner(
    modifier: Modifier = Modifier,
    selectedItem: E,
    defaultText: String = "Select...",
    itemList: List<E>,
    onItemSelect: (Int, E) -> Unit,
) {

    var isOpen by remember { mutableStateOf(false) }
    var boxWidth by remember { mutableStateOf(0) }
    Box(
        modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.surface)
            .height(48.dp)
            .background(Color.Blue.copy(alpha = 0.5f))
            .onGloballyPositioned { coordinates ->
                // 获取Box的宽度
                boxWidth = coordinates.size.width
            },
        contentAlignment = Alignment.CenterStart
    ) {

        if (selectedItem == null || selectedItem.toString().isEmpty()) {
            Text(
                text = defaultText,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 3.dp),
                color = MaterialTheme.colorScheme.onSurface.copy(.45f)
            )
        }

        Text(
            text = selectedItem.toString(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 32.dp, bottom = 3.dp),
            color = MaterialTheme.colorScheme.onSurface
        )
        Icon(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 8.dp)
                .size(24.dp),
            painter = painterResource(id = R.drawable.ic_arrow_down),
            contentDescription = "Dropdown"
        )

        DropdownMenu(
            modifier = Modifier
                .width(with(LocalDensity.current) { boxWidth.toDp() }), // 使用Box的宽度
            expanded = isOpen,
            onDismissRequest = { isOpen = false }) {
            itemList.forEachIndexed { index, item ->
                DropdownMenuItem(
                    text = {
                        Text(item.toString())
                    },
                    onClick = {
                        isOpen = false
                        onItemSelect(index, item)
                    }
                )
            }
        }

        Spacer(
            modifier = Modifier
                .matchParentSize()
                .background(Color.Transparent)
                .clickable(
                    onClick = { isOpen = true }
                )
        )

    }
}