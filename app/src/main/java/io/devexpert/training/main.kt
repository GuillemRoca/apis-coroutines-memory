package io.devexpert.training

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

// Create a flow that emits numbers from 1 to 5
// with a 100ms delay between each emission
// Double each number
// Filter out odd numbers
// Collect and print the results

fun main() = runBlocking {
    val flow = flow {
        for (i in 1..5) {
            delay(100)
            emit(i)
        }
    }
        .map { it * 2 }
        .filter { it % 2 == 0 }

    flow.collect { value ->
        println(value)
    }
}