package chapter_15

import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {
        delay(1000)
        throw RuntimeException("Child coroutine failed")
    }
    println("Parent coroutine completed")
}

