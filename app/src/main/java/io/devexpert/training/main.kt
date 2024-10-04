package io.devexpert.training

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    flow {
        for (i in 1..100) {
            delay(20)
            emit(i)
            println("Emitted $i")
        }
    }
        //.buffer(10)
        //.buffer(10, BufferOverflow.DROP_OLDEST)
        //.conflate()
        //.collectLatest { value ->
        .collect { value ->
            delay(100)
            println("Collected $value")
        }
}