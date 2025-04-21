package com.shiki.kokocomposenew.component.constraintlayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.layoutId

@Preview
@Composable
fun ConstraintlayoutExample() {
    ConstraintLayout(
        modifier = Modifier
            .background(Color.White)
            .size(250.dp)
    ) {
        val (button, text) = createRefs()

        Button(onClick = {},
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(parent.start, margin = 16.dp)
            }) {
            Text("Button")
        }

        Text("Text", modifier = Modifier.constrainAs(text) {
            top.linkTo(button.bottom, margin = 16.dp)
            start.linkTo(button.start)
        })
    }
}


/**
 * 将约束条件和约束布局解耦
 */
private fun decoupledConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val button = createRefFor("button")
        val text = createRefFor("text")

        constrain(button) {
            top.linkTo(parent.top, margin = margin)
        }
        constrain(text) {
            top.linkTo(button.bottom, margin)
        }
    }
}


@Preview
@Composable
fun DecoupledConstraintLayoutExample() {
    BoxWithConstraints {
        val constraints = if (minWidth < 600.dp) {
            decoupledConstraints(margin = 16.dp) // Portrait constraints
        } else {
            decoupledConstraints(margin = 32.dp) // Landscape constraints
        }

        ConstraintLayout(
            constraints, modifier = Modifier
                .background(Color.White)
                .size(250.dp)
                .padding(start = 16.dp)
        ) {
            Button(
                onClick = { /* Do something */ },
                modifier = Modifier.layoutId("button")
            ) {
                Text("Button")
            }

            Text("Text", Modifier.layoutId("text"))
        }
    }
}