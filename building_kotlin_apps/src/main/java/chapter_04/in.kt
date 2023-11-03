package chapter_04

class Consumer<in T> {
    fun consume(value: T) {
        println(value.toString())
    }
}

fun main() {
    val consumer: Consumer<Number> = Consumer()
    val reference: Consumer<Int> = consumer
}