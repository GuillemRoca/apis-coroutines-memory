package io.devexpert.training.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Playground() {
    var visible by remember { mutableStateOf(true) }
    Column(modifier = Modifier.padding(16.dp).fillMaxSize()) {
        Button(onClick = { visible = !visible }) {
            Text("Toggle Visibility")
        }
        Spacer(modifier = Modifier.height(8.dp))
        AnimatedVisibility(visible = visible) {
            Text(
                "This content appears and disappears smoothly.",
                modifier = Modifier
                    .background(Color.Yellow)
                    .padding(16.dp)
            )
        }
    }
}