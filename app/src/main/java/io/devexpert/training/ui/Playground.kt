package io.devexpert.training.ui

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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun Playground() {
    var cpuResult by remember { mutableStateOf("") }
    var ioResult by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.padding(16.dp)) {
        Button(onClick = {
            scope.launch {
                cpuResult = performCPUTask()
            }
        }) {
            Text("Run CPU Task")
        }
        Text("CPU Result: $cpuResult")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            scope.launch(Dispatchers.IO) {
                ioResult = performIOTask()
            }
        }) {
            Text("Run IO Task")
        }
        Text("IO Result: $ioResult")
    }
}

suspend fun performCPUTask(): String = withContext(Dispatchers.Default) {
    // Simulate CPU-intensive task
    var result = 0
    for (i in 1..1_000_000) {
        result += i
    }
    "Sum: $result"
}

suspend fun performIOTask(): String = withContext(Dispatchers.IO) {
    // Simulate I/O operation
    delay(2000)
    "Data fetched successfully"
}