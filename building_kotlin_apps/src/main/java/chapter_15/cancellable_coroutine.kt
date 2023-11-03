package chapter_15

import kotlinx.coroutines.*

suspend fun main() {
    val job = GlobalScope.launch {
        // This loop is cancellable
        while (isActive) {
            println("I'm working hard")
            delay(100) // This suspending function checks for cancellation
        }
    }

    delay(1000)
    println("I'm tired of waiting")
    job.cancel() // This will cancel the job
    job.join()
    println("Now I can quit")

}
