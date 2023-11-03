package chapter_05

annotation class ClassInfo(val type: String)

fun displayInfo(classInfo: ClassInfo): Unit = TODO()

fun main(arguments: Array<String>) {
    displayInfo(ClassInfo("String"))
}
