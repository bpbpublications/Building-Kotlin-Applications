package chapter_02.kotlin

import kotlin.math.pow

fun main() {
    // Calculate the sphere volume with 5.0 m radius
    val volume = calculateSphereVolume(5.0)
    println(volume)

    // Read CSV file
    readCSVFile("data.csv") // delimiter = ","

    openWindow(width = 1000, height = 800, resizable = false)

    val list = readInputs(1,2,3)

}

fun myOwnFunction(): String {
    return "This my function return"
}

//Calculate the volume of a sphere
fun calculateSphereVolume(radius: Double): Double {
    return 4 * Math.PI * radius.pow(3) / 3
}

// Read data from a CSV file
fun readCSVFile(filename: String, delimiter: String = ","): Unit {
    /**  code here */
}

fun openWindow(width: Int, height: Int, resizable: Boolean) {
    // code here...
}

fun readInputs(vararg args: Int) {
    // consider args as a list
}