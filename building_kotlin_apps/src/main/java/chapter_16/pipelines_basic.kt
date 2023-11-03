package chapter_16


import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel


fun main() = runBlocking {
    // Create an unbounded channel for numbers
    val numbers = Channel<Int>()

    // Launch a coroutine that sends numbers from 2 to 1000 to the channel
    launch {
        for (x in 2..1000) {
            if (!numbers.isClosedForSend) {
                numbers.send(x)
            }
        }
        numbers.close() // Close the channel when done
    }

    // Launch another coroutine that receives numbers from the channel and filters out multiples of 2
    val multiplesOfTwo = Channel<Int>()
    launch {
        for (x in numbers) { // Receive values until the channel is closed
            if (x % 2 != 0) {
                if (!multiplesOfTwo.isClosedForSend) {
                    multiplesOfTwo.send(x) // Send values to another channel
                }
            }
        }
        multiplesOfTwo.close() // Close the channel when done
    }

    // Launch another coroutine that receives numbers from the channel and filters out multiples of 3
    val multiplesOfThree = Channel<Int>()
    launch {
        for (x in multiplesOfTwo) {
            if (x % 3 != 0) {
                if (!multiplesOfThree.isClosedForSend) {
                    multiplesOfThree.send(x)
                }
            }
        }
        multiplesOfThree.close()
    }

    // Print the remaining numbers from the channel, which are prime
    for (x in multiplesOfThree) {
        println(x)
    }
}
