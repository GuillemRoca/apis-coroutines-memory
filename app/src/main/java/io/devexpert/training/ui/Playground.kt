package io.devexpert.training.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.scale
import kotlin.math.min

@Composable
fun Playground() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val minSize = size.minDimension / 2f
        val offsetX = (size.width - minSize) / 2f
        val offsetY = (size.height - minSize) / 2f
        scale(1.5f) {
            drawRect(
                color = Color.Red,
                topLeft = Offset(offsetX, offsetY),
                size = Size(minSize,minSize)
            )
        }
        drawCircle(
            color = Color.Yellow,
            center = center,
            radius = minSize / 2f
        )
    }
}