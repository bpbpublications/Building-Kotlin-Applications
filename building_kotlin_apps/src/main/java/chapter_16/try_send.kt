package chapter_16


import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val channel = Channel<Int>(capacity = 3) // Create a channel with a capacity of 3

    launch {
        channel.send(1) // This will succeed immediately
        channel.send(2) // This will succeed immediately
        channel.send(3) // This will succeed immediately
        channel.send(4) // This will block until another coroutine receives an element from the channel
        channel.close()
    }

    for (i in 1..4) {
        val result = channel.trySend(i)
        if (result.isSuccess) {
            println("Successfully sent $i")
        } else {
            println("Failed to send $i: channel is full")
        }
    }

    for (element in channel) {
        println("Received: $element")
    }
}
