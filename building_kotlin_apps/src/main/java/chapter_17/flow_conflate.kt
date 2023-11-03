package chapter_17

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val flow = flowOf(1, 2, 3, 4, 5)
        .conflate()

    flow.collect { value ->
        delay(1000) // Simulate slow processing
        println("Received: $value")
    }
}
