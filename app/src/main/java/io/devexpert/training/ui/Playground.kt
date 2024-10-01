package io.devexpert.training.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Playground() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawRect(color = Color.Magenta, size = size / 2f)
    }
}
