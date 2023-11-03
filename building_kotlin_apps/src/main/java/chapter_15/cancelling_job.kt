package chapter_15

import kotlinx.coroutines.*

suspend fun main() {
    val job = GlobalScope.launch {
        repeat(10) { i ->
            println("I'm sleeping $i ...")
            delay(500)
        }
    }

    delay(1300)
    job.cancel()
    println("Job cancelled")
}
