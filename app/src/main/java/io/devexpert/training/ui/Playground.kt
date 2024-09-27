package io.devexpert.training.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
    var expanded by remember { mutableStateOf(false) }
    Column(modifier = Modifier.padding(16.dp)) {
        Button(onClick = { expanded = !expanded }) {
            Text("Toggle Content")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .background(Color.LightGray)
                .animateContentSize()
        ) {
            Text(
                text = if (expanded) {
                    "This is expanded content with more text."
                } else {
                    "Click to expand."
                },
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}