package chapter_01.kotlin

interface Shape {
    fun print()
}

class ShapeImpl(val area: Float) : Shape {
    override fun print() { print(area) }
}

class Circle(s: Shape) : Shape by s

fun main() {
    val shape = ShapeImpl(10.0f)
    Circle(shape).print()
}
