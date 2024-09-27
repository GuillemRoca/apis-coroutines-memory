package io.devexpert.training.ui

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateOffset
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun Playground() {
    var isAnimated by remember { mutableStateOf(false) }
    val transition = updateTransition(targetState = isAnimated, label = "animation")

    val offset by transition.animateOffset(label = "offset") { animated ->
        if (animated) Offset(100f, 100f) else Offset.Zero
    }
    val rotation by transition.animateFloat(label = "rotation") { animated ->
        if (animated) 180f else 0f
    }
    val alpha by transition.animateFloat(label = "alpha") { animated ->
        if (animated) 0.5f else 1f
    }

    Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { isAnimated = !isAnimated }) {
            Text("Animate")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Box(modifier = Modifier.size(200.dp)) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .offset { IntOffset(offset.x.roundToInt(), offset.y.roundToInt()) }
                    .rotate(rotation)
                    .alpha(alpha)
                    .background(Color.Red)
                    .padding(8.dp)
            ) {
                Text(
                    text = "Multi-prop",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}