package chapter_09.reducing

import io.reactivex.rxjava3.core.Observable

fun main() {
    val numbers = Observable.fromArray(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val average = numbers
        .reduce(0) { acc, next -> acc + next }
        .zipWith(numbers.count()) { sum, count -> sum.toDouble() / count }
        .toObservable()
    average.subscribe { println(it) }
}
