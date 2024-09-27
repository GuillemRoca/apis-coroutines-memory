package io.devexpert.training.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.unit.dp

@Composable
fun Playground() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val canvasQuadrantSize = size / 2F
        inset(
            horizontal = 20.dp.toPx(),
            vertical = 20.dp.toPx()
        ) {
            drawRect(color = Color.Green, size = canvasQuadrantSize)
        }
    }
}
