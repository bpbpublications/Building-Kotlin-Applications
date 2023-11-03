package chapter_16

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

fun main(): Unit = runBlocking {
    val channel = Channel<Int>()

    // Launch a coroutine to send data to the channel
    launch {
        for (i in 1..5) {
            println("Sending $i")
            channel.send(i)
        }
        channel.close()
    }

    // Launch a coroutine to receive data from the channel
    launch {
        while (!channel.isClosedForReceive) {
            val data = channel.receive()
            println("Received $data")
        }
    }
}
