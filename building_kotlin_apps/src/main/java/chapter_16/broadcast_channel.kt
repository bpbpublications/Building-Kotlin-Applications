package chapter_16

import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.*
import java.util.*

fun main() = runBlocking {
    // Create a broadcast channel with a capacity of 10
    val channel = BroadcastChannel<Int>(10)

    // Launch a coroutine that sends random numbers to the channel
    val sender = launch {
        val random = Random()
        repeat(20) {
            val x = random.nextInt(100)
            channel.send(x) // Suspend until there is space in the buffer
            println("Sent $x")
        }
        channel.close() // Close the channel when done
    }

    // Launch another coroutine that subscribes to the channel and prints the values
    val subscriber1 = launch {
        val subscription = channel.openSubscription() // Subscribe to the channel
        for (x in subscription) { // Receive values until the channel is closed
            println("Subscriber 1 received $x")
        }
    }

    // Launch another coroutine that subscribes to the channel and prints the values
    val subscriber2 = launch {
        val subscription = channel.openSubscription() // Subscribe to the channel
        for (x in subscription) { // Receive values until the channel is closed
            println("Subscriber 2 received $x")
        }
    }

    // Wait for all coroutines to finish
    sender.join()
    subscriber1.join()
    subscriber2.join()
}
