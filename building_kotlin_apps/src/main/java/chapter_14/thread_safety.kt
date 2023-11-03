package chapter_14


import kotlinx.coroutines.*

suspend fun printData() {
    println("Printing data from coroutine: ${Thread.currentThread().name}")
    delay(1000)
    println("Data printing complete")
}

fun main() {
    println("Main thread: ${Thread.currentThread().name}")
    runBlocking {
        launch {
            printData()
        }
    }
    println("Coroutine execution complete")
}
