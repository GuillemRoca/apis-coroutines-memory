package io.devexpert.training

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// Create a MutableStateFlow for the counter
// Implement a function to increment the counter
// Collect the StateFlow and print each value
// Increment the counter 5 times with a delay between each increment

fun main() = runBlocking {
    val counter = MutableStateFlow(0)

    launch {
        counter.collect { value ->
            println("Counter value: $value")
        }
    }

    repeat(5) {
        delay(100)
        counter.value++
    }

    delay(1000)
}