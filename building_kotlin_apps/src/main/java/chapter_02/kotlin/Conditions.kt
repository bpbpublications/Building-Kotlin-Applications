package chapter_02.kotlin

fun main() {
    val a = 21
    val b= 54
    val max = if (a > b) b else a


    val gender = "M"

    when(gender) {
        "M" -> print("Male")
        "F" -> print("Female")
        else -> print("Unknown")
    }


    val bit = Bit.ONE
    val num = when (bit) {
        Bit.ONE -> 1
        Bit.ZERO -> 0
    }

    val language = "fr"
    when (language) {
        "en", "fr" -> println("Supported")
        else -> println("Not supported")
    }

    val value = ""
    when(value) {
        is String -> true
        else -> false
    }

    repeat(100) {
        println(it)
        println("This line will be printed many times")
    }

}

val restrictedAges = listOf<Int>()
fun isAuthorized(age: Int): Boolean = when(age) {
    in 18..30, !in restrictedAges -> true
    else -> false
}

enum class Bit {ZERO, ONE}