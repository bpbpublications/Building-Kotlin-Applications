package chapter_13

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job: Job = launch {
        // Coroutine code goes here
    }

    if (job.isActive) {
        // coroutine is still running
    } else {
        // coroutine not running
    }

    job.join()

    job.cancel()
}
