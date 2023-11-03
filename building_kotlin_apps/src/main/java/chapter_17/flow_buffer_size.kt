package chapter_17

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val numbers = (1..10).asFlow()

    numbers.buffer(3) // Specify a buffer size of 3

    numbers.collect { value ->
        delay(1000) // Simulate slow processing
        println("Received: $value")
    }
}
