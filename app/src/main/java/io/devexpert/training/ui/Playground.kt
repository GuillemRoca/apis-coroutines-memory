package io.devexpert.training.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.dp
import kotlin.math.min

@Composable
fun Playground() {
    val textMeasurer = rememberTextMeasurer()
    Canvas(modifier = Modifier.fillMaxSize()) {
        val minSize = size.minDimension / 2f
        val offsetX = (size.width - minSize) / 2f
        val offsetY = (size.height - minSize) / 2f
        drawText(textMeasurer, "Hello World")
        withTransform({
            rotate(45f)
            translate(60f, 60f)
            scale(0.5f)
        }) {
            drawRect(
                color = Color.Red,
                topLeft = Offset(offsetX, offsetY),
                size = Size(minSize,minSize)
            )
            drawCircle(
                color = Color.Yellow,
                center = center,
                radius = minSize / 4f
            )
        }
    }
}