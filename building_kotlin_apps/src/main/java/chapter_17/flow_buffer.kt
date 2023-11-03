package chapter_17

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flowOf

suspend fun main() {
    val flow = flowOf(1, 2, 3, 4, 5)
        .buffer(2) // Set buffer size to 2

    flow.collect { value ->
        println("Received: $value")
        delay(1000) // Simulate slow processing
    }
}
