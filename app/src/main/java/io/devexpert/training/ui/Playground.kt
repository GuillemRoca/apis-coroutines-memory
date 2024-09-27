package io.devexpert.training.ui

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import io.devexpert.training.R
import kotlinx.coroutines.launch
import kotlin.math.abs

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

    Image(
        painter = painterResource(id = R.drawable.dog),
        contentDescription = "Draggable dog image",
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .size(100.dp)
            .graphicsLayer {
                with(offset.value) {
                    scaleX = abs(x / 100 + 1f)
                    scaleY = abs(y / 100 + 1f)
                    translationX = x
                    translationY = y
                    shadowElevation = abs(x / 10)
                    rotationX = x / 10
                    rotationY = y / 10
                    alpha = 1 - (abs(x) + abs(y)) / 1000
                }
            }
            .then(dragModifier)
    )
}