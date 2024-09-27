package io.devexpert.training.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color

@Composable
fun Playground() {
    Spacer(modifier = Modifier
        .fillMaxSize()
        .drawBehind {
            drawRect(color = Color.Magenta, size = size / 2f)
        }
    )
}