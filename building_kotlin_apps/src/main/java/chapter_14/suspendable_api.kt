package chapter_14

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    coroutineScope {
        launch {
            // Child coroutine 1
            delay(1000)
            println("Task 1 completed")
        }
        launch {
            // Child coroutine 2
            delay(2000)
            println("Task 2 completed")
        }
        println("Performing other operations...")
    }
    println("All tasks completed")
}
