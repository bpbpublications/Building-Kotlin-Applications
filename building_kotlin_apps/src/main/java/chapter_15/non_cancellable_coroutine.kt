package chapter_15

import kotlinx.coroutines.*

suspend fun main() {
    val job = GlobalScope.launch {
        // This loop is not cancellable
        while (true) {
            println("I'm working hard")
        }
    }

    delay(1000)
    println("I'm tired of waiting")
    job.cancel() // This will not cancel the job
    job.join()
    println("Now I can quit")
}
