package chapter_14

import kotlinx.coroutines.delay

suspend fun fetchDataFromAPI(url: String): String {
    // Perform network request or other asynchronous operation
    delay(1000)
    return "Response from API"
}

suspend fun processResponse(response: String): String {
    // Process the response asynchronously
    delay(500)
    return "Processed: $response"
}

// Test function
suspend fun testFunction() {
    val response = fetchDataFromAPI("https://example.com")
    val processedResponse = processResponse(response)
    // Assert the processed response
}

suspend fun performTaskA() {
    println("Task A started")
    delay(1000)
    println("Task A completed")
}

suspend fun performTaskB() {
    println("Task B started")
    delay(500)
    println("Task B completed")
}

// Main function
suspend fun main() {
    println("Execution started")
    performTaskA()
    performTaskB()
    println("Execution completed")
}
