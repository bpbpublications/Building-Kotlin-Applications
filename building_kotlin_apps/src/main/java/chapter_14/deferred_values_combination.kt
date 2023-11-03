package chapter_14

import kotlinx.coroutines.*

suspend fun performTask_1(): Int {
    delay(1000)
    return 42
}

suspend fun performTask_2(): String {
    delay(500)
    return "Hello, World!"
}

fun main() {
    runBlocking {
        val deferredA: Deferred<Int> = async { performTask_1() }
        val deferredB: Deferred<String> = async { performTask_2() }

        val results: List<Any> = awaitAll(deferredA, deferredB)

        println("Result 1: ${results[0]}")
        println("Result 2: ${results[1]}")
    }
}
