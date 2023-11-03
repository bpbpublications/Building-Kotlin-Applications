package chapter_03.delegation

/*
class Rectangle(val width: Int, val height: Int) {
    fun area() = width * height
}

class Window(val shape: Rectangle) {
    // Delegation of area calculation to the internal Rectangle
    fun area() = shape.area()
}
*/



interface ClosedShape {
    fun area(): Int
}

class Rectangle(val width: Int, val height: Int) : ClosedShape {
    override fun area() = width * height
}

class Window(private val shape: ClosedShape) : ClosedShape by shape