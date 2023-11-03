package chapter_15

import kotlinx.coroutines.*

suspend fun main() {
    val job = GlobalScope.launch {
        try {
            repeat(10) { i ->
                println("I'm sleeping $i ...")
                delay(500)
            }
        } catch (e: CancellationException) {
            println("I was cancelled")
            // We can access the cause of the cancellation
            println("The cause was: ${e.localizedMessage}")
        }
    }
    delay(1300)
    println("I'm tired of waiting")
    // We can pass an optional cause for the cancellation
    job.cancel(CancellationException("Timeout"))
    job.join()
    println("Now I can quit")
}
