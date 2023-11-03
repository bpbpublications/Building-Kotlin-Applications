package chapter_09.processors

import io.reactivex.rxjava3.processors.BehaviorProcessor

fun main() {
    val numbers: BehaviorProcessor<Int> = BehaviorProcessor.createDefault(0)
    numbers.onNext(1)
    numbers.onNext(2)
    numbers.subscribe { x -> println("Subscriber 1: $x") }
    numbers.onNext(3)
    numbers.subscribe { x -> println("Subscriber 2: $x") }
}
