package chapter_05

fun isEven(x: Int) = x % 2 == 0

fun isEven(s: String) = s.length % 2 == 0

fun main() {
    val numList = listOf(1,2,3,4,5,6,7,8,9)
    println(numList.filter(::isEven))

    val names = listOf("a", "ab", "abc", "abcd", "abcde", "abcdef")
    val isEvenRef: (String) -> Boolean = ::isEven
    println(names.filter(isEvenRef))
}