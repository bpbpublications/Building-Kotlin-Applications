package chapter_17

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun streamOfIntegers(): Flow<Int> = flow {
    for (i in 1..10) {
        delay(100) // Simulate asynchronous delay
        emit(i) // Emit the next integer
    }
}

fun main() = runBlocking {
    streamOfIntegers().collect { value ->
        println(value) // Print each value
    }
}
