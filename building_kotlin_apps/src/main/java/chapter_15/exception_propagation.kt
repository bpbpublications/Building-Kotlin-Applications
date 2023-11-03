package chapter_15

import kotlinx.coroutines.*

fun doSomething() {
    throw IllegalStateException("Something went wrong")
}

suspend fun main() {
    GlobalScope.launch {
        doSomething()
    }.join()
}
