package chapter_02.kotlin

fun main() {

    val z = Complex(1f, -1f) + Complex(2f, -3f)
    println(z) // Prints: Complex(3, -4)

}

data class Complex(val x: Float, val y: Float) {
    operator fun plus(o: Complex): Complex {
        return Complex(x + o.x, y + o.y)
    }

    override fun toString(): String {
        return "Complex($x, $y)"
    }
}
