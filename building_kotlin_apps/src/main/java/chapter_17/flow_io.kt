package chapter_17

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() = runBlocking {
    val files = listOf("file1.txt", "file2.txt", "file3.txt")

    withContext(Dispatchers.IO) {
        files.forEach { file ->
            // Use coroutine flow to download files concurrently
            flow {
                // Simulate downloading the file
                val content = downloadFile(file)
                emit(content)
            }.collect { content ->
                // Process the downloaded content
                processContent(content)
            }
        }
    }
}

suspend fun downloadFile(file: String): String {
    // Simulate downloading file asynchronously
    delay(1000)
    return "Content of $file"
}

fun processContent(content: String) {
    println("Processing: $content")
}
