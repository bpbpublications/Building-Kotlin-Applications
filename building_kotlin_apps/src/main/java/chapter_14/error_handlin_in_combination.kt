package chapter_14

import kotlinx.coroutines.*

suspend fun performTaskM(): Int {
    delay(1000)
    return 42
}

suspend fun performTaskN(): String {
    delay(500)
    throw RuntimeException("Task N failed")
}

fun main() {
    runBlocking {
        val deferredM: Deferred<Int> = async { performTaskM() }
        val deferredN: Deferred<String> = async { performTaskN() }
        try {
            val results: List<Any> = awaitAll(deferredM, deferredN)
            println("Result M: ${results[0]}")
            println("Result N: ${results[1]}")
        } catch (e: Exception) {
            println("Error occurred: ${e.message}")
        }
    }
}
