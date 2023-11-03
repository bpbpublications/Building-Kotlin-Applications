package chapter_06

fun main() {
    println(factorial(0))
}

// Pure functions
fun factorial(n: Int): Int {
    if (n == 0) return 1
    return n* factorial(n-1)
}

//fun isProductAvailable(product: String): Boolean {
//    val count = getProductCount()
//    return count > 0
//}