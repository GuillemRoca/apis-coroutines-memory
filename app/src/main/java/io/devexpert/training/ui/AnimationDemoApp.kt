package io.devexpert.training.ui

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

@Composable
fun AnimationDemoApp() {
    var selectedAnimation by remember { mutableStateOf("Tween") }
    var isAnimating by remember { mutableStateOf(false) }
    var dropdownExpanded by remember { mutableStateOf(false) }

    val animationTypes = listOf(
        "Tween",
        "Spring",
        "Keyframes",
        "Repeatable",
        "InfiniteRepeatable",
        "Snap",
    )

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Animation Demo",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // DropdownMenu
        Box(modifier = Modifier.wrapContentSize(Alignment.TopStart)) {
            OutlinedButton(
                onClick = { dropdownExpanded = true },
                modifier = Modifier.fillMaxWidth(0.7f),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Text(text = selectedAnimation, fontSize = 16.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = "Dropdown Arrow"
                )
            }

            DropdownMenu(
                expanded = dropdownExpanded,
                onDismissRequest = { dropdownExpanded = false },
                modifier = Modifier.fillMaxWidth(0.7f)
            ) {
                animationTypes.forEach { animationType ->
                    DropdownMenuItem(
                        text = { Text(animationType) },
                        onClick = {
                            selectedAnimation = animationType
                            isAnimating = false
                            dropdownExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón de Animación
        Button(
            onClick = { isAnimating = !isAnimating },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isAnimating) Color.Red else Color.Blue
            )
        ) {
            Text(text = if (isAnimating) "Reset" else "Animate", color = Color.White)
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Área de Animación
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            AnimatedBox(animationType = selectedAnimation, isAnimating = isAnimating)
        }
    }
}

@Composable
fun AnimatedBox(animationType: String, isAnimating: Boolean) {
    var targetValue by remember { mutableFloatStateOf(0f) }

    LaunchedEffect(isAnimating) {
        targetValue = if (isAnimating) 300f else 0f
    }

    val animatedValue by animateFloatAsState(
        targetValue = targetValue,
        animationSpec = when (animationType) {
            "Tween" -> tween(durationMillis = 1000)
            "Spring" -> spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            )

            "Keyframes" -> keyframes {
                durationMillis = 1000
                0f at 0 using LinearOutSlowInEasing
                150f at 500 using FastOutLinearInEasing
                300f at 1000
            }

            "Repeatable" -> repeatable(
                iterations = 3,
                animation = tween(durationMillis = 300),
                repeatMode = RepeatMode.Reverse
            )

            "InfiniteRepeatable" -> infiniteRepeatable(
                animation = tween(durationMillis = 300),
                repeatMode = RepeatMode.Reverse
            )

            "Snap" -> snap()

            else -> tween(durationMillis = 1000)
        },
        label = "AnimatedValue"
    )

    Box(
        modifier = Modifier
            .size(50.dp)
            .offset { IntOffset(x = animatedValue.roundToInt(), y = 0) }
            .background(Color.Blue)
    )
}