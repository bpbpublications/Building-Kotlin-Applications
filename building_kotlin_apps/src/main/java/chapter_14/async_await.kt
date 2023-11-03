package chapter_14

import kotlinx.coroutines.*

suspend fun performTask1(): Int {
    delay(1000)
    return 42
}

suspend fun performTask2(): String {
    delay(500)
    return "Hello, World!"
}

 fun main() {
     runBlocking {

         val deferredA: Deferred<Int> = async { performTask1() }
         val deferredB: Deferred<String> = async { performTask2() }

         val resultA: Int = deferredA.await()
         val resultB: String = deferredB.await()

         println("Result A: $resultA")
         println("Result B: $resultB")
     }
}
