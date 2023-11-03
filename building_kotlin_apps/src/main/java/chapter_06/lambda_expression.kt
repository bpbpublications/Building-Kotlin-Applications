package chapter_06

fun main() {
    // declare a lambda expression
    val multiply = { a: Int, b: Int -> a * b }
    // call the function and print the result
    println("4 * 5 = ${multiply(4, 5)}")

    // Type Declaration
    val wordLength: (String) -> Int = {word -> word.length}
    val printLong: (Long) -> Unit = { ln -> println(ln) }
    val withMixedArgs: (String, Int, Boolean) -> Int = { str, n, isTrue ->
        if (isTrue) str.length else n
    }
}