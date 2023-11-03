package chapter_02.kotlin

fun main() {
    println(getSize(12))
    println(getSize(listOf("AA", "BB")))
    println("Hello Kotlin")
}

fun getSize(obj: Any): Int = when(obj) {
    is String -> obj.length
    is Int -> obj
    is List<*> -> obj.size
    else -> 0
}