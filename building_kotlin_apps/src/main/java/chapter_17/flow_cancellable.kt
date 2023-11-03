package chapter_17

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    val flow = flow {
        repeat(1000) {
            emit(it)
            delay(100)
        }
    }

    val job = flow
        .onEach { println("Received: $it") }
        .onCompletion { println("Flow completed") }
        .cancellable()
        .launchIn(this)

    // Simulate cancellation after 500 ms
    delay(500)
    job.cancel()
}
