package chapter_16

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.*

fun main() = runBlocking {
    // Create a channel with a capacity of 10
    val channel = Channel<Int>(10)

    // Launch a coroutine that sends numbers from 1 to 1000 to the channel
    val sender = launch {
        for (x in 1..1000) {
            channel.send(x) // Suspend until there is space in the buffer
            println("Sent $x")
        }
        channel.close() // Close the channel when done
    }

    // Launch another coroutine that receives numbers from the channel and prints them
    val receiver = launch {
        while (isActive) {
            val result = channel.tryReceive() // Try to receive without suspending
            if (result.isSuccess) {
                val x = result.getOrNull()
                println("Received $x")
            } else {
                println("Channel is empty")
            }
            delay(100) // Wait for 100 ms
        }
    }

    // Wait for 1 second and cancel the receiver
    delay(1000)
    receiver.cancel()
    println("Receiver cancelled")

    // Wait for the sender to finish sending all the values to the channel
    sender.join()
    println("Sender done")
}
