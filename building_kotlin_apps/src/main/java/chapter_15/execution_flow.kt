package chapter_15

import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {
        delay(1000)
        println("Child coroutine completed")
    }
    println("Parent coroutine completed")
}
