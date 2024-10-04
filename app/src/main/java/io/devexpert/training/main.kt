package io.devexpert.training
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.awaitClose
import kotlin.random.Random

fun temperatureSensorFlow(): Flow<Int> = callbackFlow {
    val sensor = TemperatureSensor { temp ->
        trySend(temp)
    }

    sensor.start()

    awaitClose {
        sensor.stop()
    }
}

class TemperatureSensor(private val callback: (Int) -> Unit) {
    private var isActive = false
    private var job: Job? = null

    fun start() {
        isActive = true
        job = CoroutineScope(Dispatchers.Default).launch {
            while (isActive) {
                delay(500L)
                val temp = Random.nextInt(20, 30)
                callback(temp)
            }
        }
    }

    fun stop() {
        isActive = false
        job?.cancel()
    }
}

fun main() = runBlocking {
    val tempFlow = temperatureSensorFlow().take(5)
    tempFlow.collect { temp ->
        println("Temperature: $temp°C")
    }
}