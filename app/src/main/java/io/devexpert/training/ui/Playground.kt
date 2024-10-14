package io.devexpert.training.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

@Composable
fun Playground() {
    //Text("Hello, World!")
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawRect(color = Color.Yellow, size = size / 2f, topLeft = Offset(300f, 300f))
        drawCircle(color = Color.Green, center = center, radius = size.width / 4f)
    }
    Spacer(
        modifier = Modifier
            .fillMaxSize()
            .drawBehind {
                drawRect(color = Color.Magenta, size = size / 2f, topLeft = Offset(200f, 200f))
                drawCircle(color = Color.Blue, radius = 100f, center = Offset(300f, 300f))
            }
    )
}