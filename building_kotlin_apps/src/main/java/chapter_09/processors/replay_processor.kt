package chapter_09.processors

import io.reactivex.rxjava3.processors.ReplayProcessor

fun main() {
    val numbers: ReplayProcessor<Int> = ReplayProcessor.createWithSize(2)
    numbers.onNext(1)
    numbers.onNext(2)
    numbers.onNext(3)
    numbers.subscribe { x -> println("Subscriber 1: $x") }
    numbers.subscribe { x -> println("Subscriber 2: $x") }
}
