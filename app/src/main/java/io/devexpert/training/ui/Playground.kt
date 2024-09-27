package io.devexpert.training.ui

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun Playground() {
    val offset = remember { Animatable(Offset.Zero, Offset.VectorConverter) }
    val coroutineScope = rememberCoroutineScope()

    val dragModifier = Modifier.pointerInput(Unit) {
        detectDragGestures(
            onDrag = { change, dragAmount ->
                change.consume()
                coroutineScope.launch {
                    offset.snapTo(offset.value + Offset(dragAmount.x, dragAmount.y))
                }
            },
            onDragEnd = {
                coroutineScope.launch {
                    offset.animateTo(
                        targetValue = Offset.Zero,
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                }
            }
        )
    }

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .then(dragModifier)
    ) {
        drawCircle(
            color = Color.Blue,
            radius = 50.dp.toPx(),
            center = center + offset.value
        )
    }
}