package chapter_09.reducing

import io.reactivex.rxjava3.core.Observable

fun main() {
    val numbers: Observable<Int> = Observable.fromArray(1, 2, 3, 4, 5)
    val sum: Int = numbers.reduce(0) { x, y -> x + y }.blockingGet()
    println("Sum: $sum")
}
