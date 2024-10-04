package io.devexpert.training

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

// Create two flows:
// 1. Emits numbers 1 to 5 with 100ms delay
// 2. Emits letters A to E with 150ms delay
// Combine these flows
// Collect and print the combined results

fun main() = runBlocking {
    val flow1 = flow {
        for (i in 1..5) {
            delay(100)
            emit(i)
        }
    }
    val flow2 = flow {
        for (char in 'A'..'E') {
            delay(150)
            emit(char.toString())
        }
    }

    flow1.combine(flow2) { num, char -> "$num$char" }
        .collect { value ->
            println(value)
        }
}