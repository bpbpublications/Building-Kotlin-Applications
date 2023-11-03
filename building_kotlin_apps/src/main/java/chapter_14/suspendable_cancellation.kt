package chapter_14

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun performTask() {
    try {
        repeat(1000) { index ->
            println("Task in progress: $index")
            delay(500)
        }
    } finally {
        println("Task cancelled or completed")
    }
}

suspend fun main() {
    val job = GlobalScope.launch {
        performTask()
    }
    delay(2500)
    job.cancel()
}

