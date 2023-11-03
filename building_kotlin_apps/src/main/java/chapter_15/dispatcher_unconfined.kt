package chapter_15

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    launch(Dispatchers.Unconfined) {
        // This coroutine will run on the main thread,
        // but may switch to another thread later
        println("Started on thread ${Thread.currentThread().name}")
        delay(500)
        println("Resumed on thread ${Thread.currentThread().name}")
    }
    println("Hello,")
    delay(1000)
    println("world!")
}
