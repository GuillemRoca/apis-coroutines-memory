package io.devexpert.training.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Playground() {
    Text(
        text = "Hola",
        modifier = Modifier
            .drawWithContent {
                // Dibujar círculo de fondo
                drawCircle(color = Color.Cyan, radius = 30.dp.toPx())

                // Dibujar el contenido original (el texto)
                drawContent()

                // Dibujar círculo por encima
                drawCircle(color = Color.Red, radius = 10.dp.toPx())
            }
    )
}
