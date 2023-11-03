package chapter_09.processors

import io.reactivex.rxjava3.processors.PublishProcessor

fun main() {
    val numbers: PublishProcessor<Int> = PublishProcessor.create()
    numbers.subscribe { x -> println("Subscriber 1: $x") }
    numbers.subscribe { x -> println("Subscriber 2: $x") }
    numbers.onNext(1)
    numbers.onNext(2)
}
