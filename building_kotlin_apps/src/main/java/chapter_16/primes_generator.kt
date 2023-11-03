package chapter_16

fun generatePrimes(): Sequence<Int> = generateSequence(2) { current ->
    generateSequence(current + 1) { it + 1 }.first { next ->
        (2 until next).none { next % it == 0 }
    }
}

fun main() {
    val primes = generatePrimes().take(10).toList()
    println(primes) // Output: [2, 3, 5, 7, 11, 13, 17, 19, 23, 29]
}
