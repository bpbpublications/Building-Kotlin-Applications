package chapter_04

fun <T> printValue(value: T) {
    println(value)
}

fun main() {
    printValue<Int>(120)
    printValue<Boolean>(true)
    printValue("Hello Kotlin")
}