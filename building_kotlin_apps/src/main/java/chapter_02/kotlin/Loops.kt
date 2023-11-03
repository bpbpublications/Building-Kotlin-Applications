package chapter_02.kotlin

fun main() {

    // calculate the sum of squared numbers less or equal 20
    var sum = 0
    for (x in 1..20) {
        if (x % 2 == 0) sum += x*x
    }
    println("Sum = $sum")

    for (i in 6 downTo 0 step 2) {
        println(i)
    }

    for (i in 5 until 50 step 5) {
        println(i)
    }

    val array = arrayOf("Eat", "Code", "Sleep")
    for (index in array.indices) {
        println(array[index])
    }

    for ((index, value) in array.withIndex()) {
        println("The value at index $index is $value")
    }
}
