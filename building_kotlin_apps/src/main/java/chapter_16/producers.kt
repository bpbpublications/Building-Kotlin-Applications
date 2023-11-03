package chapter_16

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.*


fun CoroutineScope.fibonacci(): ReceiveChannel<Int> = produce {
    var a = 0
    var b = 1
    while (true) {
        send(a) // Suspend until there is space in the buffer or the channel is closed
        val tmp = a + b
        a = b
        b = tmp
    }
}

fun CoroutineScope.printer(): SendChannel<String> = actor {
    for (msg in channel) { // Receive messages until the channel is closed
        println(msg)
    }
}

