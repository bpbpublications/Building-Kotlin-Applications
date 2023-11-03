package chapter_14

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

suspend fun fetchData(): List<String> {
    // simulate network request execution time
    delay(2500)
    return listOf("data chunk 1", "data chunk 2", "data chunk 3")
}


fun main() {
    runBlocking {
        val data = fetchData()
        println(data)
    }
}
