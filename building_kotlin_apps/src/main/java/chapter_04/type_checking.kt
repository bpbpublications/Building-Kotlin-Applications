package chapter_04

open class Shape {
    override fun toString(): String {
        return this.javaClass.simpleName
    }
}

class Circle : Shape()
class Triangle : Shape()
class Square : Shape()

inline fun <reified T> List<Any>.filterShapes(): List<T> {
    return this.filter {it is T}.map { it as T }
}

fun main() {
    val shapes = listOf<Shape>(Circle(), Triangle(), Circle(), Square())

    val circles = shapes.filterShapes<Circle>()

    println(circles)
}