package chapter_04


open class BaseClass {
    override fun toString(): String {
        return this.javaClass.simpleName
    }
}

class Derived(val name: String) : BaseClass()
class Child(val name: String) : BaseClass()
class OtherClass(val name: String)


fun <T : BaseClass> returnElementAsList(element: T?): List<T> {
    if (element == null) return emptyList()
    return listOf(element)
}

// Multiple upper bounds
fun <T> returnAnElementAsList(element: T?): List<T>
        where T : BaseClass,
              T : Comparable<T> {
    if (element == null) return emptyList()
    return listOf(element)
}

fun main() {
    val list = returnElementAsList<BaseClass>(Derived("Derived"))
    val list2 = returnElementAsList<BaseClass>(Child("Child"))
    val list3 = returnElementAsList<BaseClass>(BaseClass())
//    val list4 = returnElementAsList<OtherClass>(OtherClass("Other"))

    println(list)
    println(list2)
    println(list3)
}