package io.devexpert.training.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.min

@Composable
fun Playground() {
    var cpuResult by remember { mutableStateOf("") }
    var ioResult by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.padding(16.dp)) {
        Button(onClick = {
            // Call CPU-intensive task
            scope.launch(Dispatchers.Default) {
                val result = performCPUTask()
                withContext(Dispatchers.Main) {
                    cpuResult = result
                }
            }
        }) {
            Text("Run CPU Task")
        }
        Text("CPU Result: $cpuResult")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            // Call I/O task
            scope.launch(Dispatchers.IO) {
                val result = performIOTask()
                withContext(Dispatchers.Main) {
                    ioResult = result
                }
            }
        }) {
            Text("Run IO Task")
        }
        Text("IO Result: $ioResult")
    }
}

fun performCPUTask(): String {
    // Simulate CPU-intensive task
    var result = 0
    for (i in 1..1_000_000) {
        result += i
    }
    return "Sum: $result"
}

suspend fun performIOTask(): String {
    // Simulate I/O operation
    delay(2000)
    return "Data fetched successfully"
}