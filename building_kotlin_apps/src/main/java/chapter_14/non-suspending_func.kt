package chapter_14


fun sumNumbers(numbers: List<Int>): Int {
    return numbers.sum()
}

fun main() {
    println(sumNumbers((1..10).toList()))
}
