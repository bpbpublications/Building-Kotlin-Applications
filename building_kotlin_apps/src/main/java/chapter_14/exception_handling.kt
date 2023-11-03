package chapter_14

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

val exceptionHandler = CoroutineExceptionHandler { _, exception ->
    println("Exception caught: $exception")
}

suspend fun performWork() {
    try {
        throw RuntimeException("Something went wrong")
    } catch (e: Exception) {
        println("Caught exception: $e")
    }
}

suspend fun main() {
    val job = GlobalScope.launch(exceptionHandler) {
        performWork()
    }
    job.join()
}
