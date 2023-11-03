package chapter_03.type_aliases


typealias ClassStudents = Map<String, List<String>>

typealias KStringBuilder = kotlin.text.StringBuilder
typealias JStringBuilder = java.lang.StringBuilder


typealias MyConsumer = (Int, String, Any) -> Unit

typealias Predicate<T> = (T) -> Boolean


fun main() {
    val even: Predicate<Int> = { it % 2 == 0 }
    val evenNumbers = (1..10).filter(even)
    println(evenNumbers)

    val students: ClassStudents = mapOf(
        "A" to listOf("A1", "A2"),
        "B" to listOf("B1", "B2")
    )


    students.forEach { className, classStudents ->
        println("$className: $classStudents")
    }
}



class A {
    inner class C
}
class B {
    inner class C
}

typealias AC = A.C
typealias BC = B.C