package io.devexpert.training.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

@Composable
fun Playground() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawCircle(
            color = Color.Blue,
            radius = size.minDimension / 4,
            center = Offset(size.width / 4, size.height / 4)
        )
    }
}
