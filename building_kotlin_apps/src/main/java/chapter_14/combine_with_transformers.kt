package chapter_14

import kotlinx.coroutines.*

suspend fun performTaskC(): Int {
    delay(1000)
    return 42
}

suspend fun performTaskD(): String {
    delay(500)
    return "Hello, World!"
}

fun main() {
    runBlocking {
        val deferredC: Deferred<Int> = async { performTaskC() }
        val deferredD: Deferred<String> = async { performTaskD() }

        val result: String = deferredC.await().let { a ->
            deferredD.await().let { b ->
                "Result: $a, $b"
            }
        }

        println(result)
    }
}
