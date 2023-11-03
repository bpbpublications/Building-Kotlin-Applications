package chapter_03.types_of_classes


// Simple class
class Simple {
    val prop: Int = 25

    fun detail() {
        println("Simple with prop = $prop")
    }
}


// Open class
open class Animal(private val alive: Boolean = true) {
    fun isAlive(): Boolean {
        return alive
    }
}

class Tiger(val name: String): Animal() {
    fun roar(): String {
        return "roar-roar"
    }
}

// Data class
data class Patient(val name: String, val age: Int)


// Nested class
class Parent {

    val name = "Parent"
    fun detail() = "I am a $name class"

    class Nested {
        val name = "Nested"
        fun detail() = "I am a $name class"
    }
}

// Inner class
class Outer {
    val name1 = "Outer"
    fun show() = "the name: $name1"

    inner class Inner {

        val name2 = "Inner"
        fun show() = "data: $name2 and $name1"
    }
}

// Sealed class
sealed class Shape
class Circle(var radius: Float) : Shape()
class Square(var width: Int) : Shape()
class Rectangle(var width: Int, var height: Int) : Shape()

fun getArea(e: Shape) =
    when (e) {
        is Circle -> println("Circle area is ${Math.PI * e.radius * e.radius}")
        is Square -> println("Square area is ${e.width * e.width}")
        is Rectangle -> println("Rectangle area is ${e.width * e.height}")
    }

fun main() {

    // Sealed class
    val circle = Circle(7f)
    val square = Square(5)
    val rectangle = Rectangle(8, 6)

    getArea(circle)
    getArea(square)
    getArea(rectangle)


    // Inner class
    println(Outer().show())
    println(Outer().Inner().show())
}