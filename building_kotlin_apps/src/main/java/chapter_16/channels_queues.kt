package chapter_16

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

fun main() = runBlocking {
    val numbers = produceNumbers() // Create a producer coroutine
    val squares = List(5) { // Create 5 consumer coroutines
        launch { consumeNumbers(numbers) }
    }
    squares.forEach { it.join() } // Wait for all the consumers to finish
}

fun CoroutineScope.produceNumbers() = produce<Int> {
    for (x in 1..10) {
        send(x) // Send the numbers to the channel
    }
}

suspend fun consumeNumbers(numbers: ReceiveChannel<Int>) {
    for (x in numbers) { // Receive the numbers from the channel
        println("Square of $x is ${x * x}")
    }
}
