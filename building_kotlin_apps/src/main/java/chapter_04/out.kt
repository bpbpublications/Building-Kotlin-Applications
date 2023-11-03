package chapter_04

class Producer<out T>(val value: T) {
    fun produce(): T {
        return value
    }
}


fun main() {
    val producer = Producer("Produced")
    val reference: Producer<Any> = producer
}