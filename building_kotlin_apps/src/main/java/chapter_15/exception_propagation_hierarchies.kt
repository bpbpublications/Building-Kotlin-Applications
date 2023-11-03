package chapter_15

import kotlinx.coroutines.*

suspend fun doAnotherWork() {
    throw IllegalStateException("Something went wrong")
}

suspend fun doSomeWork() {
    doAnotherWork()
}

suspend fun main() {
    GlobalScope.launch {
        try {
            doSomeWork()
        } catch (e: Exception) {
            println("Exception caught: ${e.message}")
        }
    }.join()
}
