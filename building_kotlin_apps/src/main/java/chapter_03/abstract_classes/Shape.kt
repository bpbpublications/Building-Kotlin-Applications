package chapter_03.abstract_classes

abstract class Shape {
    abstract fun calculateArea()
}

class Circle: Shape() {
    override fun calculateArea() {
        println("Here I calculate the Circle area.")
    }
}

class Triangle: Shape() {
    override fun calculateArea() {
        println("Here I calculate the Triangle area.")
    }
}

open class CustomShape {
    open fun draw() {
        // implementation here
    }
}

abstract class MyCustomPolygon: CustomShape() {
    abstract override fun draw()
}


fun main() {
    val c1 = Circle()
    c1.calculateArea()

    val t1 = Triangle()
    t1.calculateArea()
}