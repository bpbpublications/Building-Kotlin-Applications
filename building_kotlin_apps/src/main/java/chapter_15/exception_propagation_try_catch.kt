package chapter_15

import kotlinx.coroutines.*

fun doSomethingElse() {
    throw IllegalStateException("Something went wrong")
}

suspend fun main() {
    GlobalScope.launch {
        try {
            doSomethingElse()
        } catch (e: Exception) {
            println("Exception caught: ${e.message}")
        }
    }.join()
}
