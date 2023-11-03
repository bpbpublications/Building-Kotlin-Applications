package chapter_14

import kotlinx.coroutines.*

suspend fun performTaskX(): String {
    delay(1000)
    throw RuntimeException("Task failed")
}

fun main() {
    val deferredValue: Deferred<String> = GlobalScope.async { performTaskX() }

    runBlocking {
        try {
            val result: String = deferredValue.await()
            println("Result: $result")
        } catch (e: Exception) {
            println("Error occurred: ${e.message}")
        }
    }
}
