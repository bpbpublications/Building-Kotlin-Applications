package chapter_14

import kotlinx.coroutines.*

suspend fun performAsyncTask(): Int {
    delay(1000)
    return 42
}

suspend fun main() {
    val deferredValue: Deferred<Int> = GlobalScope.async { performAsyncTask() }

    // Perform other operations

    val result: Int = deferredValue.await()
    println("Result: $result")
}
