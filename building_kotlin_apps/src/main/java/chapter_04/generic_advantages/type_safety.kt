package chapter_04.generic_advantages

// Without generics
/*class Patient(value: Int) {
    var age:Int = value
    init {
        println(age)
    }
}*/

// With generics
class Patient<T>(value: T) {
    var age:T = value
    init {
        println(age)
    }
}


fun main() {
    val patient1: Patient<Int> = Patient(35)
    val patient2: Patient<String> = Patient("60") // compile time error
}