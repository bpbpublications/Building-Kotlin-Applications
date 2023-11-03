package chapter_15

import kotlinx.coroutines.*

suspend fun calculateSum(numbers: List<Int>): Int = withContext(Dispatchers.Default) {
    numbers.sum()
}

suspend fun main() {
    val numbers = (1..100000).toList()
    val sum = calculateSum(numbers)
    println("The sum is: $sum")
}


