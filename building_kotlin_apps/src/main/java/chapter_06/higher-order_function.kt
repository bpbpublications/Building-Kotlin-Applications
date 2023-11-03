package chapter_06

fun main() {
    sumSquaredEvenNumbers()
}
// Example 1
fun printEventNumbers() {
    val evenNumbers = mutableListOf<Int>()
    (1..10).filterTo(evenNumbers) { x: Int -> x % 2 == 0 }
    println(evenNumbers)
}

// Example 2
fun printEventNumbers2() {
    val evenNumbers = mutableListOf<Int>()
    (1..10).filterTo(evenNumbers) { it % 2 == 0 }
    println(evenNumbers)
}

// Calculate the sum of squared even numbers between 1 and 100
fun sumSquaredEvenNumbers() {
    val sum = (1..100).filter {
        it % 2 == 0
    }.map {
        it*it
    }.reduce { acc, i ->
        acc + i
    }
    println("Sum = $sum")
}