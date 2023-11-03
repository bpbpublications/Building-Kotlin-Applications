package chapter_13

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("Started")

    launch {
        delay(1000)
        println("Coroutine 1 finished")
    }

    launch {
        delay(2000)
        println("Coroutine 2 finished")
    }

    println("Finished")
}
