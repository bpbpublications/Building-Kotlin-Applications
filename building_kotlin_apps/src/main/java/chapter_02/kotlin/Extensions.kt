package chapter_02.kotlin

fun main() {
    "Hello world".print()

    printClassType(Cat())
}

fun String.print() {
    println(this)
}

open class Animal
class Cat: Animal()

fun Animal.getType() = "Animal"
fun Cat.getType() = "Cat"

fun printClassType(a:Animal) {
    println(a.getType())
}

val <T> List<T>.lastIndex: Int?
    get() = if (size > 0) size - 1 else null