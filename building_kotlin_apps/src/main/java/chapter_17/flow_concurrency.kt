package chapter_17

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val numbers = (1..10).asFlow()

    numbers.flatMapMerge(concurrency = 2) { value ->
        flow {
            delay(1000) // Simulate computation time
            emit(value * 2)
        }
    }.collect { value ->
        println("Processed: $value")
    }
}
