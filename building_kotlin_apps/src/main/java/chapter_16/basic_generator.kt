package chapter_16

fun fibonacci(): Sequence<Int> = sequence {
    var a = 0
    var b = 1
    while (true) {
        yield(a)
        val tmp = a + b
        a = b
        b = tmp
    }
}

fun main() {
    val evenSequence = fibonacci().filter { it % 2 == 0 }.take(10)
    evenSequence.forEach { println(it)}
}
