package chapter_15

import kotlinx.coroutines.*

suspend fun main() {

    runBlocking {
        // This is a cancellation scope
        coroutineScope {
            launch {
                repeat(10) { i ->
                    println("I'm sleeping $i ...")
                    delay(500)
                }
            }
            launch {
                delay(1300)
                println("I'm tired of waiting")
                // This cancels all the coroutines in this scope
                cancel()
            }
        }
        println("Now I can quit")
    }

}
