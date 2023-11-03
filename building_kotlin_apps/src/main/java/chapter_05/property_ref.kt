package chapter_05

class Product(var quantity: Int) {}

var stock = 1000L

fun main() {
    var x = ::stock
    println(x.get())
    println(x.name)

    val y = Product::quantity
    println(y.get(Product(25)))

    // Constructor reference
    val z = ::Product
    println(z.name)
    println(z.parameters)
}