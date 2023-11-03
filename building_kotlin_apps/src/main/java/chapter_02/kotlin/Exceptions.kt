package chapter_02.kotlin

fun main() {
    throw Exception("I am an exception")

    try {
        // code here
    } catch (e: Throwable) {
        // handle exception here
    } finally {
        // Optional block
    }

    val userInput = "12"
    //Try expression
    val age: Int? = try {
        userInput.toInt()
    } catch (e: Throwable) {
        null
    }
}