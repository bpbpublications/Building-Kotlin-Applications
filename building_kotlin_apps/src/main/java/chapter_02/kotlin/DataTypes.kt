package chapter_02.kotlin

fun main() {
    val age = 25 // Int
    // Cannot reassign a variable declared with keyword val
//    age = 45 // Error

    var x: Int = 0
    x = 100 // Ok

    val worldPopulation = 7_953_952_577 // Long
    val area = 12200L
    val engineMaxSpeed: Short = 240

    val PI = 3.14 // Double
    val bmi = 23.0 // Double
//    val price: Double = 12000 // Error

    val g = 9.98 // Double
    val gFloat = 9.98f // Float


    // Declaring Char
    val degree: Char = 'A'
    println(degree) // Prints A

    // ASCII value not supported in Kotlin
//    val letterA: Char = 65
//    println(letterA) // Error

    // inferring String
    val greeting = "Hello World!" // String
    val country: String = "Morocco"

    // accessing string character by index
    val s = "You are doing well, keep up the good work."
    println(s[4]) // Prints a

    // Iterate over characters of a string
    val str = "ABCD"
    for (c in str) println(c)
    // Output:
    //A
    //B
    //C
    //D

    //String immutability
    val name = "abc"
    println(name.toUpperCase()) // Prints ABC
    println(name) // Prints abc

    // String length function
    val myStr = "Kotlin is awesome"
    println(myStr.length) // Prints 16

    // String get function
    val id = "ID_1"
    println(id.get(3)) // Prints 1

    // Comparing strings
    val str1 = "ABC"
    val str2 = "DEF"
    println(str1.compareTo(str2)) // Prints negative number

    // Search string in a string
    val bookText = "Building Kotlin Applications from beginner to advanced"
    println(bookText.indexOf("Kotlin"))
    println(bookText.indexOf("Java"))

    // Concatenate strings
    val a = "Hello"
    val b = "World"
    println(a.plus(" ").plus(b)) // Prints Hello World
    println(a + " " + b) // Prints Hello World

    val fullName = "Adam Smith"
    val rank = 2
    val message = "Hello $fullName, your rank in this contest is $rank"
    println(message) // Prints: Hello Adam Smith, your rank in this contest is 2

    // Split string
    val str3 = "Hello World"
    println(str3.split(" ")) // Prints: ["Hello", "World"]

    //Booleans
    val isTrue: Boolean = true
    val isFalse: Boolean = false
    val isNull: Boolean? = null

    println(isTrue || isFalse) // Prints: true
    println(isTrue && isFalse) // Prints: false
    println(!isFalse) // Prints: true


    //Arrays
    val array1 = arrayOf(1, 2, 3, 4) // array1 = [1,2,3,4]
    //print the second element in the array
    println(array1.get(1)) // Prints: 2
    println(array1[1]) // Prints: 2
    array1.set(0, 5)  // array1 = [5,2,3,4]
    //Using Array constructor
    val array2 = Array(4) { "ID_${it + 1}" } // array2: ["ID_1", "ID_2", "ID_3", "ID_4"]


    // Primitive type arrays
    val intArr = IntArray(4) // intArr = [0,0,0,0], the same as intArrayOf(0,0,0,0)
    // Initialize an array with a constant
    val intArr2 = IntArray(4) { 2022 } // intArr2 = [2022,2022,2022,2022]

}
