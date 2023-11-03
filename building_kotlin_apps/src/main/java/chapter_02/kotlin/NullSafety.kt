package chapter_02.kotlin

fun main() {
    //Nullable reference
    var age: Int? = 35
    age = null //ok

    var balance: Int = 100
//    balance = null // Compilation error

    //Convert the integer value to Double
//    println(age.toDouble()) // Error NPE
    println(balance.toDouble()) // ok

    // Safe call operator
    var country: String? = "Morocco"
    println(country?.length) // Prints: 7
    country = null
    println(country?.length) // Prints: null

    // Null check with if-else expression
    val city: String? = "Casablanca"
    val cityLength = if (city != null) city.length else null
    println(cityLength)

}