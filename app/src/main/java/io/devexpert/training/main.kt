package io.devexpert.training

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// Create a MutableSharedFlow for events
// Implement a function to send an event
// Create two collectors that print received events
// Send 5 events with a delay between each

fun main() = runBlocking {
    val events = MutableSharedFlow<String>()

    launch {
        events.collect { event ->
            println("Collector 1 received: $event")
        }
    }

    launch {
        events.collect { event ->
            println("Collector 2 received: $event")
        }
    }

    repeat(5) {
        delay(100)
        events.emit("Event ${it + 1}")
    }
}