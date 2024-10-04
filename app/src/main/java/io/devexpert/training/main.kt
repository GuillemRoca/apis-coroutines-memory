package io.devexpert.training

// Create a sequence of numbers from 1 to 100
// Filter out odd numbers
// Multiply each number by 2
// Take the first 10 elements
// Print the result

fun main() {
    val result = (1..100)
        .asSequence()
        .filter { it % 2 == 0 }
        .map { it * 2 }
        .take(10)
        .toList()

    println(result)
}