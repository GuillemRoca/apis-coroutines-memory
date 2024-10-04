package io.devexpert.training

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// Create a channel for integers
// Launch a producer coroutine that sends 5 integers to the channel
// Launch a consumer coroutine that receives from the channel and prints each value
// Close the channel after sending all values

fun main() = runBlocking {
    val channel = Channel<Int>()

    launch {
        for (i in 1..5) {
            delay(100)
            channel.send(i)
            println("Sent $i")
        }
        channel.close()
    }

    launch {
        for (value in channel) {
            println("Received $value")
        }
    }

    delay(1000)
}