package io.devexpert.training
import kotlinx.coroutines.*

suspend fun cancellableFunction() {
    var i = 0
    while (true) {
        // Simulate some work
        Thread.sleep(100)
        i++
        println("Working... $i")
        yield() // Cancellation point
    }
}

fun main() = runBlocking {
    val job = launch {
        try {
            cancellableFunction()
        } finally {
            println("Cleaning up resources...")
        }
    }

    delay(550) // Let it run for a bit
    println("Cancelling the job...")
    job.cancelAndJoin()

    println("Main: Done")
}