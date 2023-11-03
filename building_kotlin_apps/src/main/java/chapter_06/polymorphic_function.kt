package chapter_06


fun <T> List<T>.printValues(separator:String="\n") {
    this.forEach {
        print(it)
        print(separator)
    }
}

fun main() {
    val doubles = listOf<Double>(1.2, 2.3, 5.5, 7.4, 2.0)
    val names = listOf<String>("Ali", "Samir", "John", "Tania")

    doubles
        .map { it/2 }
        .filter { it > 2.0 }
        .printValues()

    names
        .filter { it.length >= 4 }
        .map { it.toUpperCase() }
        .printValues("__")
}