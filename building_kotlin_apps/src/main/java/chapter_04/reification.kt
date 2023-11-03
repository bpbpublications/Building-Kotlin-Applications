package chapter_04

import kotlin.reflect.KClass

/*
fun <T> performSomeWork(value: T) {
    println("Working on the value:")
    println(value.toString())
}
*/



/*
fun <T> performSomeWork(value: T) {
    println("Working on T: ${T::class.simpleName}") // Error
}
*/



/* //Java solution to type erasure
fun <T:Any> performSomeWork(value: T, type: KClass<T>) {
    println("Working on T: ${type.simpleName}") // Ok
}
*/



// using reified modifier with inline function
inline fun <reified T> performSomeWork(value: T) {
    println("Working on T: ${T::class.simpleName}") // Ok
}

fun main() {
    performSomeWork<String>("Learning Kotlin")
}