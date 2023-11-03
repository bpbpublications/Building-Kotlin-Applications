package chapter_06

fun main() {
    var word = "level"
    var palindrome = isPalindrome(word)
    println("The word '$word' is ${if (palindrome) "a" else "not a"} palindrome.")
    word = "stage"
    println("The word '$word' is ${if (palindrome) "a" else "not a"} palindrome.")
}

fun isPalindrome(str: String): Boolean {
    return str == str.split("").reversed().joinToString("")
}