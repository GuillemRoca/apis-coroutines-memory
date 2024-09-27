package io.devexpert.training.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.scale

@Composable
fun Playground() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        scale(2f) {
            drawCircle(
                color = Color.Red,
                radius = size.minDimension / 4,
                center = Offset(size.width / 4, size.height / 4)
            )
        }
    }
}
