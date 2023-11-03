package chapter_15

import kotlinx.coroutines.*

suspend fun main() {
    val job = GlobalScope.launch {
        try {
            repeat(10) { i ->
                println("I'm sleeping $i ...")
                delay(500)
            }
        } finally {
            // This will throw a CancellationException and skip the println
            // delay(1000)
            // This will run the suspending function without throwing an exception
            withContext(NonCancellable) {
                delay(1000)
                println("I'm running finally")
            }
            // This will check the cancellation status before running the suspending function
            if (isActive) {
                delay(1000)
                println("I'm still active")
            }
        }
    }

    delay(1300)
    println("I'm tired of waiting")
    job.cancel()
    job.join()
    println("Now I can quit")
}
