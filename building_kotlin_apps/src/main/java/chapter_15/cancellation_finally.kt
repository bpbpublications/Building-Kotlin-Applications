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
            println("I'm running finally")
        }
    }
    delay(1300)
    println("I'm tired of waiting")
    job.cancel()
    job.join()
    println("Now I can quit")
}
